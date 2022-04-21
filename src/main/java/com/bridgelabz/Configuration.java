package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for establishing connection with Database.
 *
 * @author - Moinuddin.
 */
public class Configuration {
    /**
     * Final static Strings defined for Database URL, USER_NAME and PASSWORDs.
     */
    public final static String URL = "jdbc:mysql://localhost:3306/payroll_service";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "alpha";

    /**
     * Method to establish connection to database.
     * Using Class.forName to load Database Driver for mysql.(Try catch to handle {@link ClassNotFoundException})
     * Created {@link Connection} object - connection.
     * Assigning value to connection using getConnection method from DriverManager Class by passing URL, USER_NAME and PASSWORD as arguments.
     * Try catch to handle run time exception interacting mySql Database.
     *
     * @return - connection object to be used while trying to run different Statements.
     */
    public Connection establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Connection Established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
