package com.gp2017.Model;

import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class KlasModel {
    @Autowired
    private StudentModel studentModel;

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
}
