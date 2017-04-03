package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.object.Student;

public class KlasModel {
	public static ArrayList<Student> getListStudent(String klascode) {
		try {
            Statement stat = DatabaseModel.getStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `klas_FK` = " + klascode);           
//            res.next();
//            System.out.println("DEBUG: klas = " + res.getInt("klas_FK"));
            
            ArrayList<Student> studenten = new ArrayList<Student>();
            while(res.next()) {
            	studenten.add(StudentModel.getById(res.getInt("id")));
            }
            System.out.println(res.getString("naam"));
            
            res.close();
            stat.close();
            
		    return studenten;
		    
		} catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
	}
}
