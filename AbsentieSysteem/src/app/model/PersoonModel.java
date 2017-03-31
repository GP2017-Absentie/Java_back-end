package app.model;

import app.model.DatabaseModel;
import app.object.Persoon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class PersoonModel {

    public static Persoon getById(int id) {
        try {
            Statement stat = DatabaseModel.getStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `persoon`");

            while (res.next()){
                System.out.println(res.getString("naam"));
            }


            stat.close();
            res.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
}
