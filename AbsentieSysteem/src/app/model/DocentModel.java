package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import app.object.Absentie;
import app.object.Docent;
import app.object.Les;

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
	
	public static ArrayList<Les> getLessenDocent(int docent_FK) {
		try {
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `les` WHERE `docent_FK` = '" + docent_FK + "'");
			
			ArrayList<Les> lessenDocent = new ArrayList<Les>();
			while(res.next()) {
				lessenDocent.add(LesModel.getById(res.getInt("id")));
			}
			
			res.close();
			stat.close();
			
			return lessenDocent;
		} catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
		return null;
	}
	
	public static ArrayList<Absentie> getAbsentiesDocent(int persoon_FK) {
		try {
			ArrayList<Absentie> absenties = new ArrayList<Absentie>();
			
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `persoon_FK` = '" + persoon_FK + "'");
			
			while(res.next()) {
				absenties.add(AbsentieModel.getById(res.getInt("id")));
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

}
