package com.gp2017.Model;

import com.gp2017.Entity.*;
import com.gp2017.Entity.Absentie;
import com.gp2017.RequestEntity.AbsentieRequest;
import com.gp2017.RequestEntity.ZiekteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class AbsentieModel {
    @Autowired
    private PersoonModel persoonModel;
    @Autowired
    private StudentModel studentModel;
    @Autowired
    private LesModel lesModel;

    public ArrayList<Absentie> getAll() {
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ArrayList<Absentie> absenties = new ArrayList<Absentie>();
            ResultSet res = stat.executeQuery("SELECT * FROM `absentie`");
            while (res.next()) {
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

    public Absentie getById(int id) {
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

    public void addAbsentie(AbsentieRequest absentie) {
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement(
                    "INSERT INTO absentie (reden, " +
                            "toelichting, " +
                            "persoon_FK, " +
                            "les_FK) " +
                            "VALUES ('" + absentie.getReden() + "'," +
                            "'" + absentie.getToelichting() + "" +
                            "','" + absentie.getPersoonId() + "" +
                            "','" + absentie.getLesId() + "" +
                            "')");

            prepStat.execute();
            prepStat.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public void meldZiek(ZiekteRequest ziekteRequest) throws ParseException {

        Persoon student = persoonModel.getById(ziekteRequest.getPersoonId());


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date reqDate = formatter.parse(ziekteRequest.getDatum());


        for (Les les : student) {
            java.util.Date lesDate = les.getDatum();

            System.out.println("LES\t\t"+lesDate);
            System.out.println("REQUEST\t\t"+reqDate);
            if (lesDate.equals(reqDate)) {
                AbsentieRequest absentieRequest = new AbsentieRequest();
                absentieRequest.setLesId(les.getId());
                absentieRequest.setPersoonId(persoon.getId());
                absentieRequest.setReden("ziek");
                absentieRequest.setToelichting("n.v.t.");
                System.out.println("JAAAAAAAAATOCCCCCCCCHHHHh");

                addAbsentie(absentieRequest);
            }
        }
    }

}


