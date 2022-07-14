package com.assignments.ct360java.task1.exception_assignment;

import com.assignments.ct360java.task1.exceptions.HorsepowerException;
import com.assignments.ct360java.task1.exceptions.IpSyntaxException;
import com.assignments.ct360java.task1.exceptions.KilometersException;
import com.assignments.ct360java.task1.pojos.Car;
import com.assignments.ct360java.task1.pojos.IpClass;
import com.assignments.ct360java.task1.pojos.SuperCar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionAssignment {

    private static final Logger LOGGER = Logger.getLogger(ExceptionAssignment.class.getName());

    public void Assignment() throws KilometersException {
        System.out.println("Start of the exception assignment");
        System.out.println("Setting up a logger, check his outputs on info and log flags");
        LOGGER.info("Logger Name: "+LOGGER.getName());

        /*
        To demonstrate acquired knowledge, i created spring app, where the scenario is as follows:
        We have a POJO Car, which consists of brand, model and kilometers driven so far.
        We have a POJO SuperCar, which consists of Car and horsepower.

        Demonstration scenarios:
        1. For unchecked exception (which occurs inside the code/program) I will create a new instance of Car with negative kilometers driven and supercar with too much horsepower.
        2. For checked exception (which occurs outside the code/program) I will request data from external api and then validate it.
         */

        try {
            Car carWrongKilometers = new Car("Tesla", "S", -10);
        } catch (KilometersException e1){
            //System.out.println( e1.getMessage());
            LOGGER.log(Level.SEVERE, "Specific Exception occured " + e1.getMessage());
        } catch (RuntimeException e2){
            LOGGER.log(Level.SEVERE, "Runtime Exception occured " + e2.getMessage());
        } catch (Exception e3){
            LOGGER.log(Level.ALL, "Exception occured " + e3.getMessage());
        }

        try {
            SuperCar superCarIllegalHorsepower = new SuperCar("Dodge", "Challenger", 100, 900);
        } catch (KilometersException | HorsepowerException e1){
            //System.out.println( e1.getMessage());
            LOGGER.log(Level.SEVERE, "Specific Exception occured " + e1.getMessage());
        } catch (RuntimeException e2){
            LOGGER.log(Level.SEVERE, "Runtime Exception occured " + e2.getMessage());
        } catch (Exception e3){
            LOGGER.log(Level.ALL, "Exception occured " + e3.getMessage());
        }


        try {
            SuperCar superCar1 = new SuperCar("Dodge", "Challenger Turbo", 100, 1000);
            SuperCar superCar2 = new SuperCar("Dodge", "Challenger V6", 100, 1100);
        } catch (KilometersException | HorsepowerException e1){
            //System.out.println( e1.getMessage());
            LOGGER.log(Level.SEVERE, "Specific Exception occured " + e1.getMessage());
        } catch (RuntimeException e2){
            LOGGER.log(Level.SEVERE, "Runtime Exception occured " + e2.getMessage());
        } catch (Exception e3){
            LOGGER.log(Level.ALL, "Exception occured " + e3.getMessage());
        }
/*
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
        } catch (java.io.IOException e4) {
            //e.printStackTrace();
            LOGGER.log(Level.INFO, "Exception occured " + e4.getMessage());
        }
*/
        try {
            java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream());
            IpClass ipClass = new IpClass(s.next());
            System.out.println("My current IP is:" + ipClass.getIp());
        } catch (MalformedURLException e1) {
            throw new RuntimeException(e1);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (IpSyntaxException e3) {
            LOGGER.log(Level.SEVERE, "Specific Exception occured  " + e3.getMessage());
        }
    }
}
