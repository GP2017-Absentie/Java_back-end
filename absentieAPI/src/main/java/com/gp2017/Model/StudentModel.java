package com.gp2017.Model;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class StudentModel {
    @Autowired
    private PersoonModel persoonModel;
	@Autowired
	private AbsentieModel absentieModel;
	@Autowired
	private LesModel lesModel;

	public ArrayList<Student> getAll(){
		try {
			Statement stat = DatabaseModel.myConn.createStatement();
			ArrayList<Student> students = new ArrayList<Student>();
			ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `rol` = 'student'");
			while (res.next()){
				Student s = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"), "student");
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

	            Student s = new Student(res.getInt("id"), res.getString("naam"), res.getString("email"), res.getString("wachtwoord"), res.getString("klas_FK"), "student");

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

    public Student getByEmail(String email){
        return (Student) persoonModel.getByEmail(email);
    }

    public ArrayList<Les> getLessenByStudentId(int id) {
	    Student student = getById(id);
        ArrayList<Les> lessen = new ArrayList<>();
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `les` WHERE `klas_FK` = (?)");
            prepStat.setString(1,student.getKlas());
            ResultSet res = prepStat.executeQuery();


            while (res.next()) {
                lessen.add(lesModel.getById(res.getInt("id")));
            }
            res.close();
            prepStat.close();

            return lessen;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	public ArrayList<Absentie> getAbsentiesByStudentId(int id) {
	    ArrayList<Absentie> absenties = new ArrayList<>();
		try {

            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `absentie` WHERE `persoon_FK` = (?)");
            prepStat.setInt(1,id);
            ResultSet res = prepStat.executeQuery();

			while(res.next()) {
			    System.out.println("something in the buffer");
				absenties.add(absentieModel.getById(res.getInt("id")));
			}

			res.close();
			prepStat.close();

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
