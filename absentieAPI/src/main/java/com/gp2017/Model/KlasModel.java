package com.gp2017.Model;

import com.gp2017.Entity.Klas;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class KlasModel {
    @Autowired
    private StudentModel studentModel;
    private LesModel lesModel;

    public ArrayList<Klas> getAll(){
        ArrayList<Klas> klassen = new ArrayList<Klas>();
        Klas k;
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `klas`");

            while(res.next()) {
                k = new Klas(res.getString("code"));
                PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `persoon` WHERE `klas_FK` = (?)");
                prepStat.setString(1,res.getString("code"));
                ResultSet res1 = prepStat.executeQuery();

                while (res1.next()){
                    Student stud = studentModel.getById(res1.getInt("id"));
                    k.addStudent(stud);

                }
                klassen.add(k);

                res1.close();
                prepStat.close();
            }

            res.close();
            stat.close();

            return klassen;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	public ArrayList<Student> getStudents(String klascode) {
		try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `klas_FK` = '" + klascode + "'");           

            ArrayList<Student> studenten = new ArrayList<Student>();
            while(res.next()) {
            	studenten.add(studentModel.getById(res.getInt("id")));
            }

            res.close();
            stat.close();
            
		    return studenten;
		    
		} catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
		return null;
	}

    public ArrayList<Les> getLessenKlas(String klascode) {
        try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = '" + klascode + "'");

            ArrayList<Les> lessen = new ArrayList<Les>();
            while(res.next()) {
                lessen.add(lesModel.getById(res.getInt("id")));
            }

            res.close();
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
