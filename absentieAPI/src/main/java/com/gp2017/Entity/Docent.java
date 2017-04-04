package com.gp2017.Entity;

/**
 * Object that represents a teacher. Inherited from Persoon class.
 */
public class Docent extends Persoon {
    /**
     * @param naam name of teacher
     * @param email email of teacher
     * @param pswrd password of teacher
     * @param medewerkersNummer employee number
     * @param lessen array of lesson objects corresponding to the teacher
     */
    public Docent(int id, String naam, String email, String pswrd) { //, ArrayList<Les> lessen) {
        super(id, naam, email, pswrd); //, lessen);

    }

}
