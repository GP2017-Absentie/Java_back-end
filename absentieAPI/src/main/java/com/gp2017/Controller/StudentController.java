package com.gp2017.Controller;
import com.gp2017.Entity.Student;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection getAll(){
        ArrayList<Student> students = studentService.getAll();
        HashMap<Integer, Student> allStudents = new HashMap<Integer, Student>();
        for (Student student :students){
            allStudents.put(student.getId(), student);
        }
        return allStudents.values();
    }

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
