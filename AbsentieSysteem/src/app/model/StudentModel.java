package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.object.Docent;
import app.object.Les;
import app.object.Student;

public final class StudentModel {

	 public static Student getById(int id) {
	        try {
	        	Statement stat = DatabaseModel.myConn.createStatement();
	            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `id` = " + id);           
	            res.next();
	            System.out.println("DEBUG: STUDENT ID = " + res.getInt("id"));
	            System.out.println("NAAM: " + res.getString("naam"));
	            
	            Student s = new Student(res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getInt("id"), res.getString("klas_FK"));
	             
	            res.close();
	            stat.close();
	            
	            return s;

	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        return null;
	    }
	 
	 public static ArrayList<Les> getLessenByStudentId(int id) {
		 
		 try {
			 
			 
			 	ArrayList<Les> lessen = new ArrayList<Les>();
			 
	        	Statement stat = DatabaseModel.myConn.createStatement();
	            ResultSet res = stat.executeQuery("SELECT `klas_FK` FROM `persoon` WHERE `id` = " + id); 
	            res.next();
	            
	            ResultSet res2 = stat.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = '" + res.getString("klas_FK") + "'"); 
	            
	            while (res2.next()) {
	            	lessen.add(LesModel.getById(res2.getInt("id")));
	            }
            
	            res.close();
	            res2.close();
	            stat.close();
	            
	            return lessen;

	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        return null;
		 
		 
	 }

}
