package com.gp2017.Model;

import com.gp2017.Entity.*;
import com.gp2017.Entity.Absentie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class AbsentieModel {
    @Autowired
    private PersoonModel persoonModel;
    @Autowired
    private LesModel lesModel;

    public ArrayList<Absentie> getAll(){
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ArrayList<Absentie> absenties = new ArrayList<Absentie>();
            ResultSet res = stat.executeQuery("SELECT * FROM `absentie`");
            while (res.next()){
                Absentie a = new Absentie(
                        res.getInt("id"),
                        persoonModel.getById(res.getInt("persoon_FK")),
                        lesModel.getById(res.getInt("les_FK")),
                        res.getString("reden"),
                        res.getString("toelichting"));
                absenties.add(a);
            }

            res.close();
            stat.close();

            return absenties;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	public Absentie getById (int id) {
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `id` = " + id);           
            res.next();
            Absentie a = new Absentie(
                    res.getInt("id"),
                    persoonModel.getById(res.getInt("persoon_FK")),
                    lesModel.getById(res.getInt("les_FK")),
                    res.getString("reden"),
                    res.getString("toelichting")
            );
            
            res.close();
            stat.close();
            
            return a;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public void addAbsentie(AbsentieRequest absentie){
        try{
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement(
                    "INSERT INTO absentie (reden, " +
                            "toelichting, " +
                            "persoon_FK, " +
                            "les_FK) " +
                            "VALUES ('"+absentie.getReden()+"'," +
                            "'"+absentie.getToelichting()+"" +
                            "','"+absentie.getPersoonId()+"" +
                            "','"+absentie.getLesId()+"" +
                            "')");

            prepStat.execute();
            prepStat.close();
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

}