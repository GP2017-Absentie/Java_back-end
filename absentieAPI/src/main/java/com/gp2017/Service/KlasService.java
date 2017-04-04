package com.gp2017.Service;

import com.gp2017.Entity.Klas;
import com.gp2017.Entity.Student;
import com.gp2017.Model.KlasModel;
import com.gp2017.Model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class KlasService {
    @Autowired
    private KlasModel klasModel;

    public ArrayList<Klas> getAll(){ return klasModel.getAll(); }

    public ArrayList<Student> getStudents(String id){
        return klasModel.getStudents(id);
    }
}
