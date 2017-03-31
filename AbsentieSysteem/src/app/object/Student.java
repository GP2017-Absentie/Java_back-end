package app.object;

public class Student extends Persoon {
    private int studentNummer;
    private Klas klas;

    public Student(String naam, String email, String pswrd, int studentNummer, Klas klas) {
        super(naam, email, pswrd, klas.getLessen());
        this.studentNummer = studentNummer;
        this.klas = klas;
    }
}
