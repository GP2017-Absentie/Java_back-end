package app.object;

public class Student extends Persoon {
    private int studentNummer;
    private String klas;

    public Student(String naam, String email, String pswrd, int studentNummer, String klas) {
        super(naam, email, pswrd); //, null);
        this.studentNummer = studentNummer;
        this.klas = klas;
    }
}
