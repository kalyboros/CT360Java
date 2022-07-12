package com.assignments.ct360java;

import com.assignments.ct360java.exception_assignment.ExceptionAssignment;
import com.assignments.ct360java.exceptions.HorsepowerException;
import com.assignments.ct360java.exceptions.KilometersException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ct360JavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(Ct360JavaApplication.class, args);

        ExceptionAssignment ea = new ExceptionAssignment();
        try {
            ea.Assignment();
        } catch (KilometersException e) {
            throw new RuntimeException(e);
        }

    }

}
