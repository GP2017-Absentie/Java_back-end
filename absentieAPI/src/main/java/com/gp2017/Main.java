package com.gp2017;

import com.gp2017.Model.DatabaseModel;
import com.gp2017.Model.LesModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class Main
{
    public static void main(String [] args) {
        DatabaseModel.open();
        SpringApplication.run(Main.class, args);

    }

}