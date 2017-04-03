package app.model;

import app.model.DatabaseModel;
import app.object.CoreObject;
import app.object.Persoon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersoonModel extends CoreModel {

    public PersoonModel() {
        super(Persoon.class);
    }

    @Override
    public CoreObject getById(int id) throws Exception {
        Persoon newPersoon = (Persoon) super.getById(id);



        return newPersoon;
    }
}
