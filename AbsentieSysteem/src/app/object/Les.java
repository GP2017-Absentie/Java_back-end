package app.object;

import java.util.ArrayList;
import java.util.Date;

/**
 * Object that represents a lesson.
 */
public class Les extends CoreObject {
    public String vakNaam;
    public String vakCode;
    public String gebouw;
    public String lokaal;

    public Date starttijd;
    public Date eindtijd;

    public Klas klas;
    public Docent docent;
    public ArrayList<Absentie> absenties;


    public Les()
    {

    }
}
