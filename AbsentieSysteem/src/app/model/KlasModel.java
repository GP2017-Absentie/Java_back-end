package app.model;

import app.object.CoreObject;
import app.object.Klas;
import app.object.Persoon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KlasModel extends CoreModel {
    public KlasModel() {
        super(Klas.class);
    }

    public static String getKlasForPersoon(Persoon persoon) throws SQLException {
        System.out.println(persoon);
        PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT `klas_FK` FROM `Persoon` WHERE `id` = (?)");

        prepStat.setInt(1,persoon.id);
        ResultSet res = prepStat.executeQuery();
        res.next();

        return res.getString("klas_FK");
    }
}
