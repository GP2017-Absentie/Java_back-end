package com.gp2017.Model;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Persoon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbsentieModel {
    private PersoonModel persoonModel;

	public Absentie getById (int id) {


        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `id` = " + id);           
            res.next();
            System.out.println("DEBUG: ABSENTIE ID = " + res.getInt("id"));
                        
            Persoon persoon = persoonModel.getById(res.getInt("persoon_FK"));
            Les les = LesModel.getById(res.getInt("les_FK"));
            String rede = res.getString("reden");
            String toelichting = res.getString("toelichting");
            
            Absentie a = new Absentie(persoon ,les , rede ,toelichting);
            
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

}