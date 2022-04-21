package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Statements {
    /**
     * CREATE_TABLE_QUERY - Query to create Employee Table containing id, employeeName, employeeDOJ.
     * INSERT_INTO_QUERY - Query to Insert employees into Employee Table.
     * SELECT_QUERY - Query to see all columns of all rows of Employee Table.
     * DELETE_QUERY - Query to Delete Row based on employeeName Condition.
     */
    public final static String CREATE_TABLE_QUERY = "CREATE TABLE employee(id int PRIMARY KEY AUTO_INCREMENT , employeeName varchar(20) , employeeDOJ DATE);";
    public final static String INSERT_INTO_QUERY = "INSERT INTO employee(employeeName, employeeDOJ) VALUES(? , ?);";
    public final static String SELECT_QUERY = "SELECT * FROM employee;";
    public final static String DELETE_QUERY = "DELETE FROM Employee WHERE employeeName = ?;";
    /**
     * Scanner object created to take user input.
     */
    Scanner scanner = new Scanner(System.in);
    /**
     * connection - Instance of Connection Interface.
     */
    Connection connection;
    /**
     * employeeArrayList - ArrayList of Employee Type.
     */
    ArrayList<Employee> employeeArrayList;

    /**
     * Constructor
     *
     * @param connection - Connection instance.
     */
    public Statements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method to create table in database.
     * Created Instance of Statement interface - statement.
     * In try block using connection.createStatement initialized statement.
     * executed statement with the CREATE_TABLE_QUERY.
     * Catch block to handle SQLException.
     */
    public void createTable() {
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(CREATE_TABLE_QUERY);
            System.out.println("Table Created !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to insert new row into the table.
     * Took User input for employeeName and employeeDOJ.
     * Created instance of {@link PreparedStatement} - preparedStatement
     * Than prepared statement using method prepareStatement on connection object passing INSERT_INTO_QUERY.
     * Assigned index 1 and 2's values.(By user input strings).
     * executed the preparedStatement.
     * sout employeeName Inserted.
     * Catch block to handle sql exceptions.
     */
    public void insertIntoTable() {
        System.out.println("Enter name of the Employee: ");
        String employeeName = scanner.nextLine();
        System.out.println("Enter the Date of Joining of the Employee: ");
        String employeeDOJ = scanner.nextLine();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_QUERY);
            preparedStatement.setString(1, employeeName);
            preparedStatement.setString(2, employeeDOJ);
            preparedStatement.execute();
            System.out.println(employeeName + ":Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to read the database and display in console.
     * Initialized employeeArrayList using getEmployeeDB method from EmployeeDatabase Class.
     * created a Statement object and initialized in try block using createStatement method - statement.
     * Defined ResultSet object using executeQuery on statement.
     * While resultSet.next has value. employee object will have all column values for each row.
     * Adding the employee object to employeeArrayList.
     * Printing the employeeArrayList.
     */
    public void retrieveTable() {
        employeeArrayList = EmployeeDatabase.getEmployeeDB();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                employeeArrayList.add(employee);

            }
            System.out.println(employeeArrayList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to delete a row.
     * Taking user input for employeeName.
     * Created instance of {@link PreparedStatement} - preparedStatement
     * Than prepared statement using method prepareStatement on connection object passing DELETE_QUERY.
     * Assigned index with employeeName value.(from User Input).
     * executed the preparedStatement.
     * sout
     */
    public void deleteRow() {
        System.out.println("Enter name of the Employee to Delete");
        String employeeName = scanner.nextLine();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setString(1, employeeName);
            preparedStatement.execute();
            System.out.println("Employee with Name: " + employeeName + "Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
