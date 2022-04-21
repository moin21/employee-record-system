package com.bridgelabz;

/**
 * POJO Class for Employee
 *
 * @author Moinuddin
 */
public class Employee {
    public int employeeId;
    public String employeeName;
    public String employeeDOJ;

    /**
     * Constructor
     *
     * @param employeeId   - Employee ID
     * @param employeeName - Employee Name
     * @param employeeDOJ  - Employee Date Of Joining
     */
    public Employee(int employeeId, String employeeName, String employeeDOJ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDOJ = employeeDOJ;
    }

    /**
     * ToString Method
     */
    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", employeeName='" + employeeName + '\'' + ", employeeDOJ='" + employeeDOJ + '\'' + '}';
    }
}
