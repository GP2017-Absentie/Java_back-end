package com.gp2017.Model;


import com.gp2017.Entity.Docent;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Les;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

@Repository
public class LesModel {

    public ArrayList<Les> getAll(){
        try {
            ArrayList<Les> resultArray = new ArrayList<Les>();
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet resultSet = stat.executeQuery("SELECT * FROM `les`");


            while(resultSet.next()) {
                int les_id = resultSet.getInt("id");
                int vak_FK = resultSet.getInt("vak_FK");
                String klas = resultSet.getString("klas_FK");
                int lokaal_FK = resultSet.getInt("lokaal_FK");
                int docent_FK = resultSet.getInt("docent_FK");
                Time starttijd = resultSet.getTime("starttijd"); // 10:00:00
                Time eindtijd = resultSet.getTime("eindtijd"); // 12:30:00

                Statement stat1 = DatabaseModel.myConn.createStatement();
                ResultSet vakResult = stat1.executeQuery("SELECT * FROM `vak` WHERE `id` = " + vak_FK);
                vakResult.next();

                String vakNaam = vakResult.getString("naam");
                String vakCode = vakResult.getString("code");

                Statement stat2 = DatabaseModel.myConn.createStatement();
                ResultSet lokaalResult = stat2.executeQuery("SELECT * FROM `lokaal` WHERE `id` = " + lokaal_FK);
                lokaalResult.next();

                String gebouw = lokaalResult.getString("gebouw");
                String lokaal_nummer = lokaalResult.getString("nummer");

                Docent docent = DocentModel.getById(docent_FK);
                //ArrayList<Absentie> absenties  = AbsentieService.getById(les_id); ABSENTIEMODEL

                Les l = new Les(les_id, vakNaam, vakCode, gebouw, lokaal_nummer, starttijd, eindtijd, klas, docent);
                resultArray.add(l);
                stat1.close();
                stat2.close();
                vakResult.close();
                lokaalResult.close();
            }
            resultSet.close();
            stat.close();

            return resultArray;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	public Les getById(int id) { // VERVANG Les DATE door Les TIME
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `les` WHERE `id` = " + id);           
            res.next();
            System.out.println("DEBUG: ID = " + res.getInt("id"));
            
            int les_id = res.getInt("id");
            int vak_FK = res.getInt("vak_FK");
            String klas = res.getString("klas_FK");
            int lokaal_FK = res.getInt("lokaal_FK");
            int docent_FK = res.getInt("docent_FK");
            Time starttijd = res.getTime("starttijd"); // 10:00:00
            Time eindtijd = res.getTime("eindtijd"); // 12:30:00
            
            
            System.out.println(starttijd);
            System.out.println(eindtijd);
            

            res = stat.executeQuery("SELECT * FROM `vak` WHERE `id` = " + vak_FK);
            res.next();

            String vakNaam = res.getString("naam");
            String vakCode = res.getString("code");
            
            
            
            res = stat.executeQuery("SELECT * FROM `lokaal` WHERE `id` = " + lokaal_FK);
            res.next();
            	
            String gebouw = res.getString("gebouw");
            String lokaal_nummer = res.getString("nummer");
                        
            Docent docent = DocentModel.getById(docent_FK);
            //ArrayList<Absentie> absenties  = AbsentieService.getById(les_id); ABSENTIEMODEL
            
            Les l = new Les(les_id, vakNaam,vakCode,gebouw,lokaal_nummer,starttijd,eindtijd, klas, docent);
                        
            res.close();
            stat.close();
            
            return l;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}
