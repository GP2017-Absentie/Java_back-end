package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.gp2017.View.LesView;
import com.gp2017.View.View;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Object that represents a lesson.
 */
public class Les {
    @JsonProperty("lesId")
    @JsonView(LesView.Minimal.class)
    private int id;
    @JsonView(LesView.Minimal.class)
    private String vakNaam;
    @JsonView(LesView.Full.class)
    private String vakCode;
    @JsonView(LesView.Full.class)
    private String gebouw;
    @JsonView(LesView.Full.class)
    private String lokaal;
    @JsonView(LesView.Full.class)
    private Date datum;
    @JsonView(LesView.Full.class)
    private Time starttijd;
    @JsonView(LesView.Full.class)
    private Time eindtijd;
    @JsonView(LesView.Full.class)
    private String klas;
    @JsonView(LesView.Full.class)
    private Docent docent;
    @JsonView(LesView.Full.class)
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
    public Les(int id, String vakNaam, String vakCode, String gebouw, String lokaal, Date datum, Time starttijd, Time eindtijd, String klas,
               Docent docent)
    {
        this.id = id;
        this.vakNaam = vakNaam;
        this.vakCode = vakCode;
        this.gebouw = gebouw;
        this.lokaal = lokaal;
        this.datum = datum;
        this.starttijd = starttijd;
        this.eindtijd = eindtijd;
        this.klas = klas;
        this.docent = docent;
        this.absenties = new ArrayList<Absentie>();
    }
    
    public void addAbsentie(Absentie abs) {
    	this.absenties.add(abs);
    }

    public String getVakNaam() {
        return vakNaam;
    }

    public int getId() {
        return id;
    }

    public String getVakCode() {
        return vakCode;
    }

    public String getGebouw() {
        return gebouw;
    }

    public String getLokaal() {
        return lokaal;
    }

    public Time getStarttijd() {
        return starttijd;
    }

    public Time getEindtijd() {
        return eindtijd;
    }

    public Date getDatum() {
        return datum;
    }

    public String getKlas() {
        return klas;
    }

    public Docent getDocent() {
        return docent;
    }

    public ArrayList<Absentie> getAbsenties() {
        return absenties;
    }
}


