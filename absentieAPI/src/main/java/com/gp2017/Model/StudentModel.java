package com.gp2017.Model;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class StudentModel {
	private static Map<Integer, Student> students;
	private AbsentieModel absentieModel;
	private LesModel lesModel;

	public ArrayList<Student> getAll(){
		try {
			Statement stat = DatabaseModel.myConn.createStatement();
			ArrayList<Student> students = new ArrayList<Student>();
			ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `rol` = 'student'");
			while (res.next()){
				Student s = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"));
				students.add(s);
			}

			res.close();
			stat.close();

			return students;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}

	public Student getById(int id) {

	        try {
				PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `persoon` WHERE `id` = (?) AND `rol` = 'student'");
				prepStat.setInt(1,id);
				ResultSet res = prepStat.executeQuery();

	            res.next();
	            System.out.println("DEBUG: STUDENT ID = " + res.getInt("id"));
	            System.out.println("NAAM: " + res.getString("naam"));
	            
	            Student s = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"));

	            res.close();
	            prepStat.close();
	            
	            return s;

	        } catch (SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        }
	        return null;
	    }


	public ArrayList<Les> getLessenByStudentId(int id) {
		try {
			ArrayList<Les> lessen = new ArrayList<Les>();

			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT `klas_FK` FROM `persoon` WHERE `id` = " + id);
			res.next();

			ResultSet res2 = stat.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = '" + res.getString("klas_FK") + "'");

			while (res2.next()) {
				lessen.add(lesModel.getById(res2.getInt("id")));
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

	public ArrayList<Absentie> getAbsentiesStudentId(int id) {
		try {
			ArrayList<Absentie> absenties = new ArrayList<Absentie>();

			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `persoon_FK` =  '" + id + "'");

			while(res.next()) {
				absenties.add(absentieModel.getById(res.getInt("id")));
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
