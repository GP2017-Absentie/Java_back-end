package app;

import app.model.AbsentieModel;
import app.model.DatabaseModel;
import app.model.LesModel;
import app.model.PersoonModel;

class main
{
    public static void main(String [] args) {
        DatabaseModel.open();
        //PersoonModel.getById(1);
        //Absentie a1 = new Absentie()
        LesModel.getById(1);
        //PersoonModel.getById(8);
        //AbsentieModel.getById(1);
        //LesModel.getById(23);



    }

}
