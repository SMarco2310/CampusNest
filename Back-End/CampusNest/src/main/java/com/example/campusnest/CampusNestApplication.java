package com.example.campusnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class CampusNestApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(CampusNestApplication.class, args);
    }

}
