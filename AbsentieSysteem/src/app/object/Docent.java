package app.object;

import java.util.ArrayList;

public class Docent extends Persoon {
    private int medewerkersNummer;


    public Docent(String naam, String email, String pswrd, int medewerkersNummer, ArrayList<Les> lessen) {
        super(naam, email, pswrd, lessen);
        this.medewerkersNummer = medewerkersNummer;
    }
}
