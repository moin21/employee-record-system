package com.bridgelabz;

import java.util.ArrayList;

/**
 * Class containing ArrayList of EmployeePayroll Type - employeeDB. & method to return the same ArrayList.
 *
 * @author - Moinuddin.
 */
public class EmployeeDatabase {
    /**
     * Arraylist of Employee Type - employeeDB
     */
    static ArrayList<Employee> employeeDB = new ArrayList<>();

    /**
     * Method to get employeeDB.
     *
     * @return - employeeDB.
     */
    public static ArrayList<Employee> getEmployeeDB() {
        return employeeDB;
    }
}
