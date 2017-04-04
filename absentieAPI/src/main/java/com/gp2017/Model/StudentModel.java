package com.gp2017.Model;

import com.gp2017.Entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

@Repository
public class StudentModel {
	private static Map<Integer, Student> students;

	 public Student getById(int id) {

	        try {
                Statement stat = DatabaseModel.myConn.createStatement();
	            System.out.println(stat);
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