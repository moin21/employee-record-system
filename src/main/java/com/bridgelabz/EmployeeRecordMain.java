package com.bridgelabz;

import java.util.Scanner;

public class EmployeeRecordMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Statements statements = new Statements(configuration.establishConnection());
        boolean moreChanges = true;
        while (moreChanges) {
            System.out.println("Enter Number to Perform Specific Tasks:\n " + "1. To Insert New Employee Into Table.\n 2. To Retrieve Employees from Table.\n 3. To Delete an Employee.\n 4. To Exit");
            int action = scanner.nextInt();
            switch (action) {
                case (1) -> statements.insertIntoTable();
                case (2) -> statements.retrieveTable();
                case (3) -> statements.deleteRow();
                case (4) -> {
                    moreChanges = false;
                    System.out.println("You are out of the employee reord system");
                }
            }

        }
    }
}

