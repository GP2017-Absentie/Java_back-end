package app.object;

public class Absentie {
    private Persoon persoon;
    private Les les;
    private enum Redenen{
        ziek, afwezig, zorgafspraak
    }

    private Redenen redenAbsentie;
    private String toelichting;

    public Absentie(Persoon persoon, Les les,Redenen redenAbsentie, String toelichting) {
        this.persoon = persoon;
        this.les = les;
        this.redenAbsentie = redenAbsentie;
        this.toelichting = toelichting;
    }
}
