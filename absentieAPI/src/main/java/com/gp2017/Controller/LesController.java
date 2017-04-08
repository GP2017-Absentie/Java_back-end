package com.gp2017.Controller;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.LesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Collection getAll(){
        ArrayList<Les> alleLessen = lesService.getAll();
        HashMap<Integer, Les> lessen = new HashMap<>();
        for (Les les : alleLessen){
            lessen.put(les.getId(), les);
        }
        return lessen.values();
    }

    @CrossOrigin
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){
        HashMap<Integer, Les> student = new HashMap<Integer, Les>(){
            {
                put(1, lesService.getById(id));
            }
        };
        return student.values();
    }

    @CrossOrigin
    @RequestMapping(value = "/getAbsentiesByLesId/{id}")
    public Collection getAbsentiesByLesId(@PathVariable("id") int id){
        ArrayList<Absentie> alleAbsenties = lesService.getAbsentiesByLesId(id);
        HashMap<Integer, Absentie> lessen = new HashMap<>();
        for (Absentie absentie : alleAbsenties){
            lessen.put(absentie.getId(), absentie);
        }
        return lessen.values();
    }
}
