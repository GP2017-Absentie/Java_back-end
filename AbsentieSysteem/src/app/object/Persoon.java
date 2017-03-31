package app.object;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private String email;
    private String pswd;
    private ArrayList<Absentie> absenties;
    private ArrayList<Les> lessen;

    public Persoon(String naam, String email, String pswd, ArrayList<Les> lessen) {
        this.naam = naam;
        this.email = email;
        this.pswd = pswd;
        this.lessen = lessen;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Absentie> getAbsenties() {
        return absenties;
    }

    public ArrayList<Les> getLessen() {
        return lessen;
    }

    public boolean checkPswd(String pswd){
        if (this.pswd == pswd){
            return true;
        } return false;
    }

    public void addAbsentie(Absentie absentie){
        this.absenties.add(absentie);
    }

    public void delAbsentie(Absentie absentie){
        this.absenties.remove(absentie);
    }

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
