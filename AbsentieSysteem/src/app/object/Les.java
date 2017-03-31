package app.object;

import java.util.ArrayList;
import java.util.Date;

/**
 * Object that represents a lesson.
 */
public class Les {
    private String vakNaam;
    private String vakCode;
    private String gebouw;
    private String lokaal;

    private Date starttijd;
    private Date eindtijd;

    private Klas klas;
    private Docent docent;
    private ArrayList<Absentie> absenties;

    /**
     * @param vakNaam course name
     * @param vakCode course code
     * @param gebouw building
     * @param lokaal room number
     * @param starttijd start time
     * @param eindtijd end time
     * @param klas grade
     * @param docent teacher
     * @param absenties ArrayList of absence objects
     */
    public Les(String vakNaam, String vakCode, String gebouw, String lokaal, Date starttijd, Date eindtijd, Klas klas,
               Docent docent, ArrayList<Absentie> absenties)
    {
        this.vakNaam = vakNaam;
        this.vakCode = vakCode;
        this.gebouw = gebouw;
        this.lokaal = lokaal;
        this.starttijd = starttijd;
        this.eindtijd = eindtijd;
        this.klas = klas;
        this.docent = docent;
        this.absenties = absenties;
    }
}
