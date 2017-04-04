package com.gp2017.Service;

import com.gp2017.Entity.Les;
import com.gp2017.Model.LesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesService {
    @Autowired
    private LesModel lesModel;

    public Les getById(int id) { return lesModel.getById(id); }
}
