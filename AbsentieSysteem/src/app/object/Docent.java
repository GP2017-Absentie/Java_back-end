package app.object;

import java.util.ArrayList;

/**
 * Object that represents a teacher. Inherited from Persoon class.
 */
public class Docent extends Persoon {
    private int medewerkersNummer;


    /**
     * @param naam name of teacher
     * @param email email of teacher
     * @param pswrd password of teacher
     * @param medewerkersNummer employee number
     * @param lessen array of lesson objects corresponding to the teacher
     */
    public Docent(String naam, String email, String pswrd, int medewerkersNummer, ArrayList<Les> lessen) {
        super(naam, email, pswrd, lessen);
        this.medewerkersNummer = medewerkersNummer;
    }
}
