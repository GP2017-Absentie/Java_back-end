package com.gp2017.Controller;

import com.gp2017.Entity.Absentie;
import com.gp2017.Service.AbsentieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/absentie")
public class AbsentieController {

    @Autowired
    private AbsentieService absentieService;

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
