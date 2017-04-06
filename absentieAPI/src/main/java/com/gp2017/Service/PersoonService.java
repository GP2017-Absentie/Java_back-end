package com.gp2017.Service;

import com.gp2017.Entity.Persoon;
import com.gp2017.Model.PersoonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersoonService {
    @Autowired
    private PersoonModel persoonModel;

    public ArrayList<Persoon> getAll(){ return persoonModel.getAll(); }

    public Persoon getById(int id) { return persoonModel.getById(id); }

    public Persoon getByEmail(String email) { return persoonModel.getByEmail(email); }

    public Persoon login(String email, String password){
        return persoonModel.login(email, password);
    }


}
