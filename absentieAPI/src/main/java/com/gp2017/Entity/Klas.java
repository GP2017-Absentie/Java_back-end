package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.gp2017.View.KlasView;

import java.util.ArrayList;

/**
 * Object that represents a grade of students.
 */
public class Klas {
    @JsonProperty("klasId")
    @JsonView(KlasView.Minimal.class)
    private String code;
    @JsonView(KlasView.Full.class)
    private ArrayList<Student> studenten;
    @JsonView(KlasView.Full.class)
    private ArrayList<Les> lessen;

    /**
     * @param code grade code
     */
    public Klas(String code) {

        this.code = code;
        this.studenten = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudenten() {
        return studenten;
    }

    /**
     * Returns lessons of corresponding grade object
     * @return lessen
     */


    public ArrayList<Les> getLessen(){
        return this.lessen;
    }

    public void addStudent(Student s){
        this.studenten.add(s);
    }
    public void addLes(Les l){
        this.lessen.add(l);
    }

    public String getCode() {
        return code;
    }
}

