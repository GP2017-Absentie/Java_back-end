package com.gp2017.Model;

import com.gp2017.Entity.*;
import com.gp2017.Entity.Absentie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.*;
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
    private DocentModel docentModel;
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

    public void removeById(int id) {
        try {
            PreparedStatement st = DatabaseModel.myConn.prepareStatement("DELETE FROM `absentie` WHERE id = (?)");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void addAbsentie(AbsentieRequest absentieRequest) {

        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement(
                    "INSERT INTO absentie (reden, " +
                            "toelichting, " +
                            "persoon_FK, " +
                            "les_FK) " +
                            "VALUES ('" + absentieRequest.getReden() + "'," +
                            "'" + absentieRequest.getToelichting() + "" +
                            "','" + absentieRequest.getPersoonId() + "" +
                            "','" + absentieRequest.getLesId() + "" +
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
        Persoon persoon = persoonModel.getById(ziekteRequest.getPersoonId());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date reqDate = formatter.parse(ziekteRequest.getDatum());
        ArrayList<Les> lessen = new ArrayList<>();
        if (persoon.getRol().equals("student")) {
            lessen = studentModel.getLessenByStudentId(persoon.getId());
        } else if (persoon.getRol().equals("docent")) {
            lessen = docentModel.getLessenByDocentId(persoon.getId());
        }

        for (Les les : lessen) {
            java.util.Date lesDate = les.getDatum();
            System.out.println("loop");
            if (lesDate.equals(reqDate)) {
                System.out.println("lekker pik");
                AbsentieRequest absentieRequest = new AbsentieRequest();
                absentieRequest.setLesId(les.getId());
                absentieRequest.setPersoonId(persoon.getId());
                absentieRequest.setReden("ziek");
                absentieRequest.setToelichting("n.v.t.");
                addAbsentie(absentieRequest);
            }
        }
    }

}


