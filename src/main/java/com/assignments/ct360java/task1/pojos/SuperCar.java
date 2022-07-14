package com.assignments.ct360java.task1.pojos;

import com.assignments.ct360java.task1.exceptions.HorsepowerException;
import com.assignments.ct360java.task1.exceptions.KilometersException;

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
