package app;

import app.controller.DatabaseController;
import app.controller.PersoonController;

import java.sql.*;

class main
{
    public static void main(String [] args) {
        DatabaseController.open();
        PersoonController.getById(1);



    }

}
