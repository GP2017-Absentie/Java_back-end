package app.object;

/**
 * Object to hold absence instance. Takes an Les and Person object.
 */
public class Absentie extends CoreObject {
    private Persoon persoon;
    private Les les;
    private enum Redenen{
        ziek, afwezig, zorgafspraak
    }

    private Redenen redenAbsentie;
    private String toelichting;


    public Absentie() {

    }
}
