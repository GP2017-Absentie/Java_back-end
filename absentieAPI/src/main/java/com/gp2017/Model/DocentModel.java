package com.gp2017.Model;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Docent;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public final class DocentModel {
    @Autowired
    private LesModel lesModel;
    @Autowired
    private AbsentieModel absentieModel;
    @Autowired
    private PersoonModel persoonModel;

    public ArrayList<Docent> getAll(){
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ArrayList<Docent> docents = new ArrayList<Docent>();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `rol` = 'docent'");

            while (res.next()){
                Docent s = new Docent(
                        res.getInt("id"),
                        res.getString("naam"),
                        res.getString("email"),
                        res.getString("wachtwoord"),
                        "docent"
                );
                docents.add(s);
            }

            res.close();
            stat.close();

            return docents;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	public Docent getById(int id) {
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `persoon` WHERE `id` = (?) AND `rol` = 'docent'");
            prepStat.setInt(1,id);
            ResultSet res = prepStat.executeQuery();
            res.next();

            Docent d = new Docent(
                    res.getInt("id"),
                    res.getString("naam"),
                    res.getString("email"),
                    res.getString("wachtwoord"),
                    "docent"
            );
             
            res.close();
            prepStat.close();
            
            return d;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            
        }
        return null;
    }

    public Docent getByEmail(String email){
        return (Docent) persoonModel.getByEmail(email);
    }

    public ArrayList<Les> getLessenByDocentId(int id) {
        ArrayList<Les> lessenDocent = new ArrayList<>();
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `les` WHERE `docent_FK` = (?)");
            prepStat.setInt(1,id);
            ResultSet res = prepStat.executeQuery();

            while(res.next()) {
                lessenDocent.add(lesModel.getById(res.getInt("id")));
            }

            res.close();
            prepStat.close();

            return lessenDocent;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public ArrayList<Absentie> getAbsentiesByDocentId(int id) {
        ArrayList<Absentie> absenties = new ArrayList<>();
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `absentie` WHERE `persoon_FK` = (?)");
            prepStat.setInt(1,id);
            ResultSet res = prepStat.executeQuery();

            while(res.next()) {
                absenties.add(absentieModel.getById(res.getInt("id")));
            }

            res.close();
            prepStat.close();

            return absenties;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return null;
    }

}