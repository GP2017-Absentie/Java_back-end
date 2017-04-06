package com.gp2017.Controller;

import com.gp2017.Entity.Absentie;
import com.gp2017.Service.AbsentieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
