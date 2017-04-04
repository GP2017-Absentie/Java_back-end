package com.gp2017.Entity;

/**
 * Object to hold absence instance. Takes an Les and Person object.
 */
public class Absentie {
    private Persoon persoon;
    private Les les;
    //public enum Redenen{
    //    ziek, afwezig, zorgafspraak
    //}

    //private Redenen redenAbsentie;
    private String redenAbsentie;
    private String toelichting;

    /**
     * @param persoon the person to be absent
     * @param les the lesson of absence
     * @param redenAbsentie the reason of absence
     * @param toelichting a more detailed description
     */
    public Absentie(Persoon persoon, Les les,String redenAbsentie, String toelichting) {
        this.persoon = persoon;
        this.les = les;
        this.redenAbsentie = redenAbsentie;
        this.toelichting = toelichting;
    }
}
