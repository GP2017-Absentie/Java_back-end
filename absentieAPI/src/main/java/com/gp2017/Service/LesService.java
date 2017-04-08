package com.gp2017.Service;

import com.gp2017.Entity.Absentie;
import com.gp2017.Entity.Les;
import com.gp2017.Entity.Student;
import com.gp2017.Model.LesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LesService {
    @Autowired
    private LesModel lesModel;

    public ArrayList<Les> getAll() { return lesModel.getAll(); }

    public Les getById(int id) { return lesModel.getById(id); }

    public ArrayList<Absentie> getAbsentiesByLesId(int id){ return lesModel.getAbsentieByLesId(id); }

    public ArrayList<Student> getStudentenByLesId(int id) { return lesModel.getStudentenByLesId(id); }
}
