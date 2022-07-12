package com.assignments.ct360java.exceptions;

public class HorsepowerException extends Exception {
    private Integer horsepower;

    public HorsepowerException(Integer horsepower){
        super("Your horsepower exceeds the legal limit of 600! Yours is: " + horsepower);
        this.horsepower = horsepower;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }
}
