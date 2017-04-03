package app.model;

import java.sql.*;

public final class DatabaseModel {
    private static Connection myConn;
    private static Statement myStatement;
    private static ResultSet myResultSet;

    public static void open() {
        Connection conn = null;
        // ...
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/absentiesys", "root", "");
            myStatement = myConn.createStatement();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static Statement getStatement(){
        return myStatement;
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
