package com.gp2017.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.gp2017.View.StudentView;
import org.springframework.stereotype.Repository;

import java.util.Map;

public class Student extends Persoon {
    @JsonProperty("klasId")
    @JsonView(StudentView.Full.class)
    private String klas;

    public Student(int id, String naam, String email, String pswrd, String klas) {
        super(id, naam, email, pswrd); //, null);
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
