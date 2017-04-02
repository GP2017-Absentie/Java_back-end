package app.object;

import java.util.ArrayList;

/**
 * Object that represents a grade of students.
 */
public class Klas extends CoreObject {
    private String code;
    private ArrayList<Student> _studenten;
    private ArrayList<Les> _lessen;

    /**
     * @param code grade code
     * @param studenten ArrayList of students
     * @param lessen ArrayList of lessons
     */
    public Klas() {

    }




    public String getCode() {
        return code;
    }

    /**
     * Returns lessons of corresponding grade object
     * @return lessen
     */
    public ArrayList<Les> getLessen(){
        return this._lessen;
    }
}
