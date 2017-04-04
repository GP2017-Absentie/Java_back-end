package com.gp2017.Entity;

import org.springframework.stereotype.Repository;

import java.util.Map;

public class Student extends Persoon {
    private int studentNummer;
    private String klas;

    public Student(String naam, String email, String pswrd, int studentNummer, String klas) {
        super(naam, email, pswrd); //, null);
        this.studentNummer = studentNummer;
        this.klas = klas;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public String getKlas() {
        return klas;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nStudent{" +
                "studentNummer=" + studentNummer +
                ", klas='" + klas + '\'' +
                '}';
    }
}
