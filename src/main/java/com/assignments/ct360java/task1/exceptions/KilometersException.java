package com.assignments.ct360java.task1.exceptions;

public class KilometersException extends Exception {
    private Integer kilometers;

    public KilometersException(Integer kilometers){
        super("Kilometers can not be below 0! Yours is: " + kilometers);
        this.kilometers = kilometers;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }
}
