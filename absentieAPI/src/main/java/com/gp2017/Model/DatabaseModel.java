package com.gp2017.Model;

import java.sql.*;

public final class DatabaseModel {
    public static Connection myConn;
    private static Statement myStatement;
    private static ResultSet myResultSet;

    public static void open() {
        // ...
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/AbsentieSys", "root", "dbwarrior");
            System.out.println("myConn:\t" + myConn);
            myStatement = myConn.createStatement();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }



    public static void close(){
        try {

            myStatement.close();
            myConn.close();
        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
