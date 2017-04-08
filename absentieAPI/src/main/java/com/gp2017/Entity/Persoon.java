package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Object to represent a person
 */
public class Persoon {
    @JsonProperty("persoonId")
    private int id;
    private String naam;
    private String email;
    private String pswd;
    private ArrayList<Absentie> absenties;
    private ArrayList<Les> lessen;

    /**
     * @param naam persons name
     * @param email persons email
     * @param pswd persons password
     * @param lessen ArrayList of persons lessons
     */
    public Persoon(int id, String naam, String email, String pswd) {   //, ArrayList<Les> lessen) {
        this.id = id;
        this.naam = naam;
        this.email = email;
        this.pswd = pswd;
        this.absenties = new ArrayList<Absentie>();
        this.lessen = new ArrayList<Les>();
        //this.lessen = lessen;
    }

    public int getId() {
        return id;
    }

    /**
     * Get's persons name
     * @return name
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Get's persons email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get's persons absences
     * @return ArrayList of Absentie objects
     */
    public ArrayList<Absentie> getAbsenties() {
        return absenties;
    }

    /**
     * Get's persons lessons
     * @return lessons
     */
    public ArrayList<Les> getLessen() {
        return lessen;
    }

    /**
     * Checks password of the user
     * @param pswd
     * @return boolean
     */
    public boolean checkPswd(String pswd){
        if (this.pswd.equals(pswd)){
            return true;
        } return false;
    }



    /**
     * adds an absence object to the ArrayList
     * @param absentie
     */
    public void addAbsentie(Absentie absentie){
        this.absenties.add(absentie);
    }

    /**
     * deletes and absence object from the ArrayList
     * @param absentie
     */
    public void delAbsentie(Absentie absentie){
        this.absenties.remove(absentie);
    }

    /**
     * adds an les object to the ArrayList
     * @param les
     */
    public void addLes(Les les){
        this.lessen.add(les);
    }

    /**
     * deletes and les object from the ArrayList
     * @param les
     */
    public void delLes(Les les){
        this.lessen.remove(les);
    }

    /**
     * check if an object is equal to another.
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persoon){
            Persoon otherPersoon = (Persoon) obj;
            if (this.naam.equals(otherPersoon.getNaam()) &&
                    this.email.equals(otherPersoon.getEmail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", pswd='" + pswd + '\'' +
                ", absenties=" + absenties +
                ", lessen=" + lessen +
                '}';
    }
}
