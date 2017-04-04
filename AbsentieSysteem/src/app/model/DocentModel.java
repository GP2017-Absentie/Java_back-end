package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import app.object.Docent;

public final class DocentModel {

	public static Docent getById(int id) {
        try {
        	Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `id` = " + id);           
            res.next();
            System.out.println("DEBUG: DOCENT ID = " + res.getInt("id"));
            
            Docent d = new Docent(res.getString("naam"), res.getString("email"), res.getString("wachtwoord"),res.getInt("id"));
             
            res.close();
            stat.close();
            
            return d;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            
        }
        return null;
    }

}
