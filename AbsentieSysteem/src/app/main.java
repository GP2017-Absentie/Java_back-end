package app;

import app.model.DatabaseModel;
import app.model.LesModel;
import app.model.PersoonModel;
import app.model.StudentModel;
import app.object.Klas;
import app.object.Les;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class main
{
    public static void main(String [] args) throws Exception {
        DatabaseModel.open();

        LesModel studMod = new LesModel();
        try {
            studMod.getLessenByKlas("V1D");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    }


