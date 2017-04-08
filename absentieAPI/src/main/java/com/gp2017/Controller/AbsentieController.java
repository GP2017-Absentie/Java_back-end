package com.gp2017.Controller;

import com.gp2017.Entity.*;
import com.gp2017.Service.AbsentieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/absentie")
public class AbsentieController {

    @Autowired
    private AbsentieService absentieService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Absentie>> getAll() {
        return new ResponseEntity<>(absentieService.getAll(), HttpStatus.OK);
    }


    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Absentie> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(absentieService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/absent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void meldAbsent(@RequestBody AbsentieRequest absentieRequest) {
        if (absentieRequest != null) {
            absentieService.addAbsentie(absentieRequest);
        } else throw new IllegalArgumentException("Something went wrong");


    }

    @CrossOrigin
    @RequestMapping(value = "/ziek", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void meldZiek(@RequestBody ZiekteRequest ziekteRequest) throws ParseException {
        if (ziekteRequest != null){
            absentieService.meldZiek(ziekteRequest);
        } else throw new IllegalArgumentException("Something went wrong");
    }
}
