package com.gp2017.Service;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    private StudentModel studentModel;

    public ArrayList<Student> getAll() { return studentModel.getAll(); }

    public Student getById(int id){
        return studentModel.getById(id);
    }

    public ArrayList<Les> getLessenByStudentId(int id) { return studentModel.getLessenByStudentId(id); }

    public ArrayList<Absentie> getAbsentiesByStudentId(int id) { return studentModel.getAbsentiesByStudentId(id); }


}
