package com.example.campusnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootApplication
public class CampusNestApplication {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream serviceAccount = new FileInputStream(System.getenv("firebase-service-account.json"));

        SpringApplication.run(CampusNestApplication.class, args);
    }

}
