package app;

import app.model.DatabaseModel;
import app.model.LesModel;
import app.model.PersoonModel;
import app.object.Klas;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class main
{
    public static void main(String [] args) throws Exception {
        DatabaseModel.open();

        PersoonModel permod = new PersoonModel();
        try {
            permod.getById(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    }


