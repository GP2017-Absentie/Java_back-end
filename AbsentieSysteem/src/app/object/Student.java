package app.object;

import app.model.KlasModel;

import java.sql.SQLException;
import java.util.HashMap;

public class Student extends Persoon {
    public String klas;

    public Student() {

    }

    @Override
    public void deserialize(HashMap map) {
        super.deserialize(map);
        map.forEach((k, v) -> {

            if (k.equals("klas_FK")){
                try {
                    this.klas = KlasModel.getKlasForPersoon(this);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent{" +
                "klas='" + klas + '\'' +
                '}';
    }
}
