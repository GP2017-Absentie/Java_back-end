package com.gp2017.Controller;

import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.LesService;
import org.springframework.beans.factory.annotation.Autowired;
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
        HashMap<Integer, Les> lessen = new HashMap<Integer, Les>();
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
}
