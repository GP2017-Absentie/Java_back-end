package com.gp2017.Entity;

import org.springframework.stereotype.Repository;

import java.util.Map;

public class Student extends Persoon {

    private String klas;

    public Student(int id, String naam, String email, String pswrd, String klas, String rol) {
        super(id, naam, email, pswrd, rol);
        this.klas = klas;
    }


    public String getKlas() {
        return klas;
    }



    @Override
    public String toString() {
        return super.toString()+ "\nStudent{" +
                ", klas='" + klas + '\'' +
                '}';
    }
}
