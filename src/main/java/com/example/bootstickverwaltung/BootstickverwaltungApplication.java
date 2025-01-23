package com.example.bootstickverwaltung;

import me.paulschwarz.springdotenv.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BootstickverwaltungApplication {

    public static void main(String[] args) {
        //Debug Ausdruck
        System.out.println("Current user.dir: " + System.getProperty("user.dir"));

        SpringApplication.run(BootstickverwaltungApplication.class, args);
    }

}
