package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to hold absence instance. Takes an Les and Person object.
 */
public class Absentie {
    @JsonProperty("absentieId")
    private int id;
    private Persoon persoon;
    private Les les;
    //public enum Redenen{
    //    ziek, afwezig, zorgafspraak
    //}

    //private Redenen redenAbsentie;
    private String reden;
    private String toelichting;

    /**
     * @param persoon the person to be absent
     * @param les the lesson of absence
     * @param reden the reason of absence
     * @param toelichting a more detailed description
     */
    public Absentie(int id, Persoon persoon, Les les, String reden, String toelichting) {
        this.id = id;
        this.persoon = persoon;
        this.les = les;
        this.reden = reden;
        this.toelichting = toelichting;
    }

    public Absentie(Persoon persoon, Les les, String reden, String toelichting) {
        this.persoon = persoon;
        this.les = les;
        this.reden = reden;
        this.toelichting = toelichting;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public void setLes(Les les) {
        this.les = les;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public void setToelichting(String toelichting) {
        this.toelichting = toelichting;
    }

    public int getId() {
        return id;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public Les getLes() {
        return les;
    }

    public String getToelichting() {
        return toelichting;
    }
}
