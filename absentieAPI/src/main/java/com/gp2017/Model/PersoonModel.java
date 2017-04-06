package com.gp2017.Model;

import com.gp2017.Entity.Docent;
import com.gp2017.Entity.Persoon;
import com.gp2017.Entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class PersoonModel {

    public ArrayList<Persoon> getAll() {
        try{
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon`");
            ArrayList<Persoon> allPersons = new ArrayList<Persoon>();

            while(res.next()){

                if (res.getString("rol").equals("student")){
                    Student newStudent = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"));
                    allPersons.add(newStudent);
                }
                else if (res.getString("rol").equals("docent")){
                    Docent newDocent = new Docent(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"));
                    allPersons.add(newDocent);
                }
            }
            res.close();
            stat.close();

            return allPersons;


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public Persoon getById(int id) {
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `id` = " + id);
            Persoon p = null;
            if (res.next()) {
                System.out.println("DEBUG: PERSOON ID = " + res.getInt("id"));


                if (res.getString("rol").equals("student")) {
                    p = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"));
                } else if (res.getString("rol").equals("docent")) {
                    p = new Docent(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"));
                }
            }
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

    public Persoon getByEmail(String email) {
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `persoon` WHERE `email` = (?)");
            prepStat.setString(1,email);
            ResultSet res = prepStat.executeQuery();


            Persoon p = null;
            if (res.next()) {
                if (res.getString("rol").equals("student")) {
                    p = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"));
                } else if (res.getString("rol").equals("docent")) {
                    p = new Docent(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"));
                }
                return p;
            }
            res.close();
            prepStat.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public Persoon login(String email, String password){

        Persoon persoon = getByEmail(email);
        if (persoon != null){
            if (persoon.checkPswd(password)){
                return persoon;
            }
        }
        return null;
    }

}