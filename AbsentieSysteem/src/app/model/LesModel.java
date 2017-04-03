package app.model;

import app.object.Klas;
import app.object.Les;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class LesModel extends CoreModel {
    public LesModel() {
        super(Les.class);
    }

    public ArrayList<Les> getLessenByKlas(String klas) throws SQLException {
        ArrayList<Les> lessen;
        PreparedStatement prepStat = DatabaseModel.myConn.prepareStatement("SELECT * FROM `Les` WHERE `klas_FK` = (?)");
        prepStat.setString(1,klas);
        ResultSet res = prepStat.executeQuery();
        while (res.next()){
            Les newLes = new Les();
            newLes.deserialize(super.resultSetToArrayList(res));
        }
        return null;
    }

}
