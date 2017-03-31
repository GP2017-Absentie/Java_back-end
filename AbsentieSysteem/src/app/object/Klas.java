package app.object;

import java.util.ArrayList;

public class Klas {
    private String code;
    private ArrayList<Student> studenten;
    private ArrayList<Les> lessen;

    public Klas(String code, ArrayList<Student> studenten, ArrayList<Les> lessen) {
        this.code = code;
        this.studenten = studenten;
        this.lessen = lessen;
    }

    public ArrayList<Les> getLessen(){
        return this.lessen;
    }
}
