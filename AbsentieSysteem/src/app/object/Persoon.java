package app.object;

import java.util.ArrayList;

/**
 * Object to represent a person
 */
public class Persoon {
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
    public Persoon(String naam, String email, String pswd, ArrayList<Les> lessen) {
        this.naam = naam;
        this.email = email;
        this.pswd = pswd;
        this.lessen = lessen;
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
        if (this.pswd == pswd){
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
}
