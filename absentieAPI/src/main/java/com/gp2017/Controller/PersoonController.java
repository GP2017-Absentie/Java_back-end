package com.gp2017.Controller;

import com.gp2017.Entity.Docent;
import com.gp2017.Entity.Persoon;
import com.gp2017.Service.PersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/persoon")
public class PersoonController {

    @Autowired
    private PersoonService persoonService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection getAll(){
        HashMap<Integer, Persoon> persons = new HashMap<Integer, Persoon>();
        ArrayList<Persoon> allPersons = persoonService.getAll();
        for (Persoon person : allPersons){
            persons.put(person.getId(), person);
        }
        return persons.values();
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){
        HashMap<Integer, Persoon> docent = new HashMap<Integer, Persoon>() {
            {
                put(1, persoonService.getById(id));
            }
        };
        return docent.values();
    }
}
