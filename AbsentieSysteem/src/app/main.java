package app;

import app.model.DatabaseModel;
import app.model.PersoonModel;

class main
{
    public static void main(String [] args) {
        DatabaseModel.open();
        PersoonModel.getById(1);



    }

}
