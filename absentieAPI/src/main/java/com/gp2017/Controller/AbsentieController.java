package com.gp2017.Controller;

import com.gp2017.Entity.*;
import com.gp2017.RequestEntity.AbsentieRequest;
import com.gp2017.RequestEntity.ZiekteRequest;
import com.gp2017.Service.AbsentieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Collection getAll(){
        ArrayList<Absentie> absenties = absentieService.getAll();
        HashMap<Integer, Absentie> allAbsenties = new HashMap<Integer, Absentie>();
        for (Absentie absentie : absenties){
            allAbsenties.put(absentie.getId(), absentie);
        }
        return allAbsenties.values();
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){

        HashMap<Integer, Absentie> absentie = new HashMap<Integer, Absentie>(){
            {
                put(1, absentieService.getById(id));
            }

        };
        return absentie.values();
    }

    @CrossOrigin
    @RequestMapping(value = "/meldAbsent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void meldAbsent(@RequestBody AbsentieRequest absentieRequest) {
        if (absentieRequest != null) {
            absentieService.addAbsentie(absentieRequest);
        } else throw new IllegalArgumentException("Something went wrong");


    }

    @CrossOrigin
    @RequestMapping(value = "/meldZiek", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void meldZiek(@RequestBody ZiekteRequest ziekteRequest) throws ParseException {
        if (ziekteRequest != null){
            absentieService.meldZiek(ziekteRequest);
        } else throw new IllegalArgumentException("Something went wrong");
    }
}
