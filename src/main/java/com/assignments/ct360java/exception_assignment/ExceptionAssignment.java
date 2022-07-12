package com.assignments.ct360java.exception_assignment;

import com.assignments.ct360java.exceptions.HorsepowerException;
import com.assignments.ct360java.exceptions.KilometersException;
import com.assignments.ct360java.models.Car;
import com.assignments.ct360java.models.SuperCar;

import java.io.IOException;

public class ExceptionAssignment {

    public void Assignment() throws KilometersException {
        System.out.println("Start of the exception assignment");

        /*
        To demonstrate acquired knowledge, i created spring app, where the scenario is as follows:
        We have a POJO Car, which consists of brand, model and kilometers driven so far.

        Demonstration scenarios:
        1. For unchecked exception (which occurs inside the code/program) I will create a new instance of Car with negative kilometers driven.
        2. For checked exception (which occurs outside the code/program) I will request data from external api and then validate it.
         */

        try {
            Car carWrongKilometers = new Car("Tesla", "S", -10);
            SuperCar superCarIllegalHorsepower = new SuperCar("Dodge", "Challenger", -100, 900);
        } catch (KilometersException | HorsepowerException e1){
            System.out.println( e1.getMessage());
        } catch (RuntimeException e2){
            System.out.println( e2.getMessage());
        } catch (Exception e3){
            System.out.println( e3.getMessage());
        }


    }
}
