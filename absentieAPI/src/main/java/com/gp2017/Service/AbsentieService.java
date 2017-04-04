package com.gp2017.Service;

import com.gp2017.Entity.Absentie;
import com.gp2017.Model.AbsentieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbsentieService {
    @Autowired
    private AbsentieModel absentieModel;

    public Absentie getById(int id) { return absentieModel.getById(id); }
}
