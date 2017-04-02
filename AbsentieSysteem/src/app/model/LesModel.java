package app.model;

import app.object.Klas;
import app.object.Les;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class LesModel extends CoreModel {
    public LesModel() {
        super(Les.class);
    }
    //    public static ArrayList<Les> getLesByKlas(){
//        ArrayList<Les> myLessons = new ArrayList<Les>();
//        try {
//            // ResultSet lesResult = statement.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = " + klas.getCode());
//            ResultSet lesResult = statement.executeQuery("SELECT * FROM `les` WHERE `klas_FK` = 'V1D'");
//
//            while (lesResult.next()){
//                // fetch vak
//                ResultSet resultSet = statement.executeQuery("SELECT `naam` from `vak` WHERE `id` = " +lesResult.getInt("vak_FK"));
//                resultSet.next();
//                String vak = resultSet.getString("naam");
//                System.out.println(vak);
//
//                // fetch lokaal
//
//
//
//
//
//
//            }
//        } catch (SQLException ex) {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
//
//        return null;
//    }
}
