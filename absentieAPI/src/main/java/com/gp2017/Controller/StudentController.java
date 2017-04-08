package com.gp2017.Controller;
import com.fasterxml.jackson.annotation.JsonView;
import com.gp2017.Entity.Student;
import com.gp2017.Service.StudentService;
import com.gp2017.View.PersoonView;
import com.gp2017.View.StudentView;
import com.gp2017.View.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @JsonView(PersoonView.Minimal.class)
    @RequestMapping(method = RequestMethod.GET)
    public Collection getAll(){
        ArrayList<Student> students = studentService.getAll();
        HashMap<Integer, Student> allStudents = new HashMap<Integer, Student>();
        for (Student student :students){
            allStudents.put(student.getId(), student);
        }
        return allStudents.values();
    }

    @CrossOrigin
    @JsonView(View.StudentGetByIdView.class)
    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){

        HashMap<Integer, Student> student = new HashMap<Integer, Student>(){
            {
                put(1, studentService.getById(id));
            }
        };
        return student.values();
    }


}
