package org.example;
import java.util.Scanner;

public class Main {

    // Recursive function to compute compound interest
    public static double find_comp(int tp, double p, double r) {
        if (tp == 0) {
            return p;
        }
        return find_comp(tp - 1, principal,r) * (1 + r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Finacial Forecasting of Compound Interest---");
        // User input
        System.out.print("Enter initial investment (principal) : ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (in %) : ");
        double rate_of_interest = scanner.nextDouble()/100.0;

        System.out.print("Enter number of years for forecasting: ");
        int years = scanner.nextInt();

        System.out.print("Enter compounding frequency (12 for compounded monthly, 4 for quarterly etc): ");
        int comps = scanner.nextInt();

        // calculation
        int periods = years * comps;
        double rate_of_interest_per_period = rate_of_interest / comps;

        double return_value = find_comp(periods, principal, rate_of_interest_per_period);

        // output
        System.out.printf("\nForecasted Value after %d years : ₹%.2f\n",
                years, return_value);

        scanner.close();
    }
}
