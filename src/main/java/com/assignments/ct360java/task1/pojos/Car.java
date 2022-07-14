package com.assignments.ct360java.task1.pojos;

import com.assignments.ct360java.task1.exceptions.KilometersException;

public class Car {
    private String brand;
    private String model;
    private Integer kilometers;

    public Car(String brand, String model, Integer kilometers) throws KilometersException {

        if (kilometers < 0){
            throw new KilometersException(kilometers);
        }

        this.brand = brand;
        this.model = model;
        this.kilometers = kilometers;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }
}
