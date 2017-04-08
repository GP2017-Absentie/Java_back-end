package com.gp2017.Controller;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.LesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/les")
public class LesController {

    @Autowired
    private LesService lesService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Les>> getAll(){
        return new ResponseEntity<>(lesService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Les> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(lesService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/absenties/{id}")
    public ResponseEntity<ArrayList<Absentie>> getAbsentiesByLesId(@PathVariable("id") int id){
        return new ResponseEntity<>(lesService.getAbsentiesByLesId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/studenten/{id}")
    public ResponseEntity<ArrayList<Student>> getStudentenByLesId(@PathVariable("id") int id){
        return new ResponseEntity<>(lesService.getStudentenByLesId(id), HttpStatus.OK);
    }
}
