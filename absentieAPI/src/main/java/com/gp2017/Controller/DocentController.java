package com.gp2017.Controller;
import com.gp2017.Entity.*;
import com.gp2017.Service.DocentService;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/docent")
public class DocentController {

    @Autowired
    private DocentService docentService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Docent>> getAll() {
        return new ResponseEntity<>(docentService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Docent> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(docentService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "lessen/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Les>> getLessenByStudentId(@PathVariable("id") int id) {
        return new ResponseEntity<>(docentService.getLessenByDocentId(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "absenties/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Absentie>> getAbsentiesByDocentId(@PathVariable("id") int id) {
        return new ResponseEntity<>(docentService.getAbsentiesByDocentId(id), HttpStatus.OK);
    }
}

