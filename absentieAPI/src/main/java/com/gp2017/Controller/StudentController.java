package com.gp2017.Controller;
import com.gp2017.Entity.Student;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){

        System.out.println("\nSTUDENT TO STRING");
        System.out.println(studentService.getById(id));
        System.out.println("\n");

        HashMap<Integer, Student> student = new HashMap<Integer, Student>(){
            {
                put(1, studentService.getById(id));
            }
        };
        return student.values();
    }


}
