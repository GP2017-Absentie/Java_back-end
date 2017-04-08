package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Object that represents a grade of students.
 */
public class Klas {
    @JsonProperty("klasId")
    private String code;
    private ArrayList<Student> studenten;
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

