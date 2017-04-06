package com.gp2017.Service;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.AbsentieRequest;
import com.gp2017.Model.AbsentieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AbsentieService {
    @Autowired
    private AbsentieModel absentieModel;

    public ArrayList<Absentie> getAll() { return absentieModel.getAll(); }

    public Absentie getById(int id) { return absentieModel.getById(id); }

    public void addAbsentie(AbsentieRequest absentie) { absentieModel.addAbsentie(absentie);}
}
