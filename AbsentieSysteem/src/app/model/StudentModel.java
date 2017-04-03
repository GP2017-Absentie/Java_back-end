package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.object.Persoon;
import app.object.Student;

public final class StudentModel {

	 public static Student getById(int id) {
	        try {
	            Statement stat = DatabaseModel.getStatement();
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

	}