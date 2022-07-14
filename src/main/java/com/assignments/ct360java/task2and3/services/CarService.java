package com.assignments.ct360java.task2and3.services;

import com.assignments.ct360java.task2and3.entities.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarById(Integer id);
    Car updateCar(Car updatedCar);
    void deleteCar(Integer id);
}
