--creating procedure
CREATE OR REPLACE PROCEDURE ApplyDiscountToSeniorCustomers IS
BEGIN
  FOR cust IN (
    SELECT CustomerID, DOB
    FROM Customers
    WHERE MONTHS_BETWEEN(SYSDATE, DOB) / 12 >= 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('Discount applied to eligible senior customers.');
END;
/


-- Create backup table if not exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE CustomerDOB_Backup';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
/

CREATE TABLE CustomerDOB_Backup AS
SELECT CustomerID, DOB FROM Customers WHERE ROWNUM <= 3;

--changing some customers dob to make them 60 years old
UPDATE Customers
SET DOB = TO_DATE('01-JAN-1950', 'DD-MON-YYYY')
WHERE CustomerID IN (SELECT CustomerID FROM CustomerDOB_Backup);

COMMIT;

--calling the procedure
BEGIN
  ApplyDiscountToSeniorCustomers;
END;
/
SET SERVEROUTPUT ON;

--showing modified rows and results
BEGIN
  FOR rec IN (
    SELECT b.CustomerID, c.Name, b.DOB AS OriginalDOB, c.DOB AS ModifiedDOB
    FROM CustomerDOB_Backup b
    JOIN Customers c ON b.CustomerID = c.CustomerID
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || ', Name: ' || rec.Name);
    DBMS_OUTPUT.PUT_LINE('Original DOB: ' || TO_CHAR(rec.OriginalDOB, 'DD-MON-YYYY') ||
                         ', Modified DOB: ' || TO_CHAR(rec.ModifiedDOB, 'DD-MON-YYYY'));
  END LOOP;
  
  DBMS_OUTPUT.PUT_LINE('--- Affected Loans ---');
  
  FOR rec IN (
    SELECT c.CustomerID, c.Name, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE c.CustomerID IN (SELECT CustomerID FROM CustomerDOB_Backup)
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('CustomerID: ' || rec.CustomerID || 
                         ', LoanID: ' || rec.LoanID || 
                         ', Interest Rate: ' || rec.InterestRate);
  END LOOP;
END;
/
-- Restoring original DOBs from backup and dropping the backup table
UPDATE Customers c
SET DOB = (SELECT b.DOB
           FROM CustomerDOB_Backup b
           WHERE b.CustomerID = c.CustomerID)
WHERE c.CustomerID IN (SELECT CustomerID FROM CustomerDOB_Backup);

DROP TABLE CustomerDOB_Backup;

COMMIT;

-- Enable DBMS_OUTPUT
SET SERVEROUTPUT ON;

-- 1. Update Contact Info Procedure
CREATE OR REPLACE PROCEDURE update_contact_info(
    p_customer_id IN VARCHAR2,
    p_new_phone IN VARCHAR2,
    p_new_email IN VARCHAR2
) AS
BEGIN
    UPDATE customers
    SET phone = p_new_phone, email = p_new_email
    WHERE id = p_customer_id;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No customer found with ID: ' || p_customer_id);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Contact info updated for customer ID: ' || p_customer_id);
    END IF;
END;
/

--  View data before update
SELECT * FROM customers WHERE id = 'CUST003';

--  Call update_contact_info
BEGIN
    update_contact_info('CUST003', '9998887777', 'updated_email@example.com');
END;
/

--  View data after update
SELECT * FROM customers WHERE id = 'CUST003';

-- Deleting Inactive Customers Procedure
CREATE OR REPLACE PROCEDURE delete_inactive_customers IS
BEGIN
    DELETE FROM customers
    WHERE id NOT IN (
        SELECT DISTINCT customer_id
        FROM orders
        WHERE order_date >= ADD_MONTHS(SYSDATE, -12)
    );

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' inactive customer(s) deleted.');
END;
/

-- View all customers before deletion
SELECT id, uname FROM customers;

-- Calling
BEGIN
    delete_inactive_customers;
END;
/

-- View all customers after deletion
SELECT id, uname FROM customers;



