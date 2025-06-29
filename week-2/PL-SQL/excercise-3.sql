-- Procedure 1: Apply 1% interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'savings';

    DBMS_OUTPUT.PUT_LINE('1% monthly interest applied to savings accounts.');
END;
/

-- Procedure 2: Update salary of employees by bonus 
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_Department);
END;
/

-- Procedure 3: Transfer funds between accounts with validation and transaction logging
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
) IS
    v_FromBalance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID;

    IF v_FromBalance < p_Amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: insufficient balance in source account.');
    ELSE
        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_Amount,
            LastModified = SYSDATE
        WHERE AccountID = p_FromAccountID;

        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_Amount,
            LastModified = SYSDATE
        WHERE AccountID = p_ToAccountID;

        -- Log the debit transaction
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (Transactions_seq.NEXTVAL, p_FromAccountID, SYSDATE, p_Amount, 'debit');

        -- Log the credit transaction
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (Transactions_seq.NEXTVAL, p_ToAccountID, SYSDATE, p_Amount, 'credit');

        DBMS_OUTPUT.PUT_LINE('₹' || p_Amount || ' transferred from account ' || p_FromAccountID || ' to ' || p_ToAccountID || '.');
    END IF;
END;
/

-- Enable DBMS output
SET SERVEROUTPUT ON;

-- calling procedure 1
BEGIN
    ProcessMonthlyInterest;
END;
/

-- calling procedure 2
BEGIN
    UpdateEmployeeBonus('Finance', 10);
END;
/

-- calling procedure 3
BEGIN
    TransferFunds(101, 102, 500);
END;
/


