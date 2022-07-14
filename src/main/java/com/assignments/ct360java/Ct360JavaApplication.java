package com.assignments.ct360java;

import com.assignments.ct360java.task1.exception_assignment.ExceptionAssignment;
import com.assignments.ct360java.task1.exceptions.HorsepowerException;
import com.assignments.ct360java.task1.exceptions.KilometersException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ct360JavaApplication {

    public static void main(String[] args) throws KilometersException, HorsepowerException {

        SpringApplication.run(Ct360JavaApplication.class, args);

        ExceptionAssignment ea = new ExceptionAssignment();
        ea.Assignment();

    }

}
