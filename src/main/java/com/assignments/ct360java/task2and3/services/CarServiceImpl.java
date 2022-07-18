package com.assignments.ct360java.task2and3.services;

import com.assignments.ct360java.task2and3.entities.Car;
import com.assignments.ct360java.task2and3.repos.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);

    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car updateCar(Car updatedCar) {
        return carRepository.save(updatedCar);
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }
}
