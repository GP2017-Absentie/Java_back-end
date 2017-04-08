package com.gp2017.Controller;
import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "lessen/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Les>> getLessenByStudentId(@PathVariable("id")int id){
        return new ResponseEntity<>(studentService.getLessenByStudentId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "absenties/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Absentie>> getAbsentiesByStudentId(@PathVariable("id")int id){
        return new ResponseEntity<>(studentService.getAbsentiesByStudentId(id), HttpStatus.OK);
    }
}
