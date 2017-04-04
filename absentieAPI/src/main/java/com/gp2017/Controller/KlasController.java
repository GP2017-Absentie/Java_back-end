package com.gp2017.Controller;

import com.gp2017.Entity.Student;
import com.gp2017.Service.KlasService;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/klas")
public class KlasController {
    @Autowired
    private KlasService klasService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") String id){
        ArrayList<Student> students = klasService.getStudents(id);
        HashMap<Integer, Student> classStudent = new HashMap<Integer, Student>();
        for (Student student : students){
            classStudent.put(student.getStudentNummer(), student);
        }

        return classStudent.values();
    }
}
