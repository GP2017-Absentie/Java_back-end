package com.gp2017.Model;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Persoon;
import com.gp2017.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class StudentModel {
    private static Map<Integer, Student> students;
    @Autowired
    private AbsentieModel absentieModel;
    @Autowired
    private LesModel lesModel;
    @Autowired
    private PersoonModel persoonModel;


    public ArrayList<Student> getAll() {


        ArrayList<Persoon> persons = persoonModel.getAll();
        ArrayList<Student> students = new ArrayList<Student>();

        for (Persoon p : persons) {
            students.add((Student) p);
        }

        return students;
    }

    public Student getById(int id) {
        return (Student) persoonModel.getById(id);
    }


    public ArrayList<Les> getLessen(int id) {
        Student student = getById(id);
        ArrayList<Les> lessen = new ArrayList<Les>();
        try {
            PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `les` WHERE `klas_FK` = (?)");
            prepStat.setString(1, student.getKlas());
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


    public ArrayList<Absentie> getAbsenties(int id) {
        return persoonModel.getAbsenties(id);
    }


}
