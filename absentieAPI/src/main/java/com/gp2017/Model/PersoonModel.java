package com.gp2017.Model;

import com.gp2017.Entity.Persoon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersoonModel {

    public Persoon getById(int id) {
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `id` = " + id);           
            res.next();
            System.out.println("DEBUG: PERSOON ID = " + res.getInt("id"));
            
            Persoon p = new Persoon(res.getString("naam"), res.getString("email"), res.getString("wachtwoord"));
             
            res.close();
            stat.close();
            
            return p;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}