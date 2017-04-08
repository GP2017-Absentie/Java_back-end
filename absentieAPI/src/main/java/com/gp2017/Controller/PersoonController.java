package com.gp2017.Controller;

import com.gp2017.Entity.Docent;
import com.gp2017.Entity.LoginRequest;
import com.gp2017.Entity.Persoon;
import com.gp2017.Service.PersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/persoon")
public class PersoonController {

    @Autowired
    private PersoonService persoonService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Persoon>> getAll(){
        return new ResponseEntity<>(persoonService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persoon> getById(@PathVariable("id") int id){
        return new ResponseEntity<>(persoonService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persoon> login(@RequestBody LoginRequest request) {
        Persoon p = null;
        if (request != null) {
            p = persoonService.login(request.getEmail(), request.getPassword());
            if (p != null){
                return new ResponseEntity<Persoon>(p, HttpStatus.OK);
            }
        }

        throw new IllegalArgumentException("Password or email incorrect");
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
