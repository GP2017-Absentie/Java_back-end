package app.object;

import java.util.ArrayList;

/**
 * Object that represents a grade of students.
 */
public class Klas {
    private String code;
    private ArrayList<Student> studenten;
    private ArrayList<Les> lessen;

    /**
     * @param code grade code
     * @param studenten ArrayList of students
     * @param lessen ArrayList of lessons
     */
    public Klas(String code, ArrayList<Student> studenten, ArrayList<Les> lessen) {
        this.code = code;
        this.studenten = studenten;
        this.lessen = lessen;
    }

    /**
     * Returns lessons of corresponding grade object
     * @return lessen
     */
    public ArrayList<Les> getLessen(){
        return this.lessen;
    }
}
