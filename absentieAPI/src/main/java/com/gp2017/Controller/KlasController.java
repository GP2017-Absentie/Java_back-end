package com.gp2017.Controller;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Klas;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.KlasService;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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
    public ResponseEntity<ArrayList<Klas>> getAll(){
        return new ResponseEntity<>(klasService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Student>> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(klasService.getStudentenByKlasId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/lessen/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Les>> getLessenByKlasId(@PathVariable("id") String id){
        return new ResponseEntity<>(klasService.getLessenByKlasId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/absenties/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ArrayList<Absentie>>> getAbsentiesByKlasId(@PathVariable("id") String id) {
        return new ResponseEntity<>(klasService.getAbsentiesByKlasId(id), HttpStatus.CREATED);
    }
}
