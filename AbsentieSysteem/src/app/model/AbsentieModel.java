package app.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.object.Absentie;
import app.object.Les;
import app.object.Persoon;

public final class AbsentieModel {

	public static Absentie getById (int id) {
        try {
            Statement stat = DatabaseModel.getStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM `absentie` WHERE `id` = " + id);           
            res.next();
            System.out.println("DEBUG: ABSENTIE ID = " + res.getInt("id"));
                        
            Persoon persoon = PersoonModel.getById(res.getInt("persoon_FK"));
            Les les = LesModel.getById(res.getInt("les_FK"));
            String rede = res.getString("reden");
            String toelichting = res.getString("toelichting");
            
            Absentie a = new Absentie(persoon ,les , rede ,toelichting);
            
            res.close();
            stat.close();
            
            return a;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}