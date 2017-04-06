package com.gp2017.Controller;

import com.gp2017.Entity.Docent;
import com.gp2017.Entity.Student;
import com.gp2017.Service.DocentService;
import com.gp2017.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Collection getAll(){
        ArrayList<Docent> docents = docentService.getAll();
        HashMap<Integer, Docent> allDocents = new HashMap<Integer, Docent>();
        for (Docent docent :docents){
            allDocents.put(docent.getId(), docent);
        }
        return allDocents.values();
    }

    @CrossOrigin
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id) {

        HashMap<Integer, Docent> docent = new HashMap<Integer, Docent>() {
            {
                put(1, docentService.getById(id));
            }
        };
        return docent.values();
    }
}

