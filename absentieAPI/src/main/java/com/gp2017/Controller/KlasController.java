package com.gp2017.Controller;

import com.gp2017.Entity.Klas;
import com.gp2017.Entity.Student;
import com.gp2017.Service.KlasService;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/klas")
public class KlasController {
    @Autowired
    private KlasService klasService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public Collection getAll(){
        ArrayList<Klas> klassen = klasService.getAll();
        HashMap<String, Klas> alleKlassen = new HashMap<String, Klas>();
        for (Klas klas : klassen){
            alleKlassen.put(klas.getCode(), klas);
        }
        return alleKlassen.values();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") String id){
        ArrayList<Student> students = klasService.getStudents(id);
        HashMap<Integer, Student> classStudent = new HashMap<Integer, Student>();
        for (Student student : students){
            classStudent.put(student.getId(), student);
        }

        return classStudent.values();
    }
}
