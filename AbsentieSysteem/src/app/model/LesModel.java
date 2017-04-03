package app.model;


import app.model.DatabaseModel;
import app.object.Docent;
import app.object.Les;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public final class LesModel {
	
	public static Les getById(int id) { // VERVANG Les DATE door Les TIME
        try {
            Statement stat = DatabaseModel.getStatement();
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
            //ArrayList<Absentie> absenties  = AbsentieModel.getById(les_id); ABSENTIEMODEL
            
            Les l = new Les(vakNaam,vakCode,gebouw,lokaal_nummer,starttijd,eindtijd, klas, docent);
                        
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
