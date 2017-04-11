package com.gp2017.Model;

import java.sql.*;

public class DatabaseModel {
    public static Connection myConn;
    private static Statement myStatement;
    private static ResultSet myResultSet;
    public String databaseUrl;
    public String databaseName;
    public Integer databasePort;
    public String databaseUser;
    public String databasePass;

    public DatabaseModel(String databaseUrl, String databaseName, Integer databasePort, String databaseUser, String databasePass) {
        this.databaseUrl = databaseUrl;
        this.databaseName = databaseName;
        this.databasePort = databasePort;
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
    }

    public void open() throws SQLException {
        myConn = DriverManager.getConnection("jdbc:mysql://"+databaseUrl+":"+databasePort+"/"+databaseName+"", databaseUser, databasePass);
        System.out.println("myConn:\t" + myConn);
        myStatement = myConn.createStatement();

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

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }
}
