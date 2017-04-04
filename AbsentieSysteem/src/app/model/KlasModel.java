package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.object.Les;
import app.object.Student;

public class KlasModel {
	public static ArrayList<Student> getListStudent(String klascode) {
		try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `klas_FK` = '" + klascode + "'");           
            
            ArrayList<Student> studenten = new ArrayList<Student>();
            while(res.next()) {
            	studenten.add(StudentModel.getById(res.getInt("id")));
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
	public static ArrayList<Les> getLessenKlas(String klascode) {
		try {
			Statement stat = DatabaseModel.myConn.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = '" + klascode + "'");
			
			ArrayList<Les> lessen = new ArrayList<Les>();
			while(res.next()) {
				lessen.add(LesModel.getById(res.getInt("id")));
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
