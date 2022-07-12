package com.assignments.ct360java.models;

import com.assignments.ct360java.exceptions.HorsepowerException;
import com.assignments.ct360java.exceptions.KilometersException;

public class SuperCar extends Car {
    private Integer horsepower;

    public SuperCar(String brand, String model, Integer kilometers, Integer horsepower) throws KilometersException, HorsepowerException {
        super(brand, model, kilometers);
        if (horsepower > 600) {
            throw new HorsepowerException(horsepower);
        }
        this.horsepower = horsepower;
    }


    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }
}
