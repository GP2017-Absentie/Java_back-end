package com.gp2017.Model;

import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KlasModel {
    @Autowired
    private StudentModel studentModel;

	public ArrayList<Student> getListStudent(String klascode) {
		try {
            Statement stat = DatabaseModel.myConn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon` WHERE `klas_FK` = '" + klascode + "'");           
//            res.next();
//            System.out.println("DEBUG: klas = " + res.getInt("klas_FK"));
            
            ArrayList<Student> studenten = new ArrayList<Student>();
            while(res.next()) {
            	studenten.add(studentModel.getById(res.getInt("id")));
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
		return null;
	}
}
