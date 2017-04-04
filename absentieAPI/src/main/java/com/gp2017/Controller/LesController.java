package com.gp2017.Controller;

import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Service.LesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/les")
public class LesController {

    @Autowired
    private LesService lesService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Collection getById(@PathVariable("id") int id){
        HashMap<Integer, Les> student = new HashMap<Integer, Les>(){
            {
                put(1, lesService.getById(id));
            }
        };
        return student.values();
    }
}
