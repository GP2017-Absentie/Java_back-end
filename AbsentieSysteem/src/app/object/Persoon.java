package app.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Object to represent a person
 */
public class Persoon extends CoreObject {
    public String naam;
    public String email;
    public String wachtwoord;
    public String  rol;
    public ArrayList<Absentie> absenties;
    public ArrayList<Les> lessen;

    /**
     * @param naam persons name
     * @param email persons email
     * @param pswd persons password
     * @param lessen ArrayList of persons lessons
     */

    public Persoon() {
    }


    @Override
    public void deserialize(HashMap map) {
        super.deserialize(map);
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

    public void setLessen(ArrayList<Les> lessen) {
        this.lessen = lessen;}

    /**
     * Checks password of the user
     * @param pswd
     * @return boolean
     */
    public boolean checkPassword(String pswd){
        if (this.wachtwoord.equals(pswd)){
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
    public void removeAbsentie(Absentie absentie){
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

    @Override
    public String toString() {
        return super.toString()+"\nPersoon{" +
                "naam='" + naam + '\'' +
                ", email='" + email + '\'' +
                ", pswd='" + wachtwoord + '\'' +
                ", absenties=" + absenties +
                ", lessen=" + lessen +
                '}';
    }
}
