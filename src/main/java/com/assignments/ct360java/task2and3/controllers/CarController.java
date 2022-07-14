package com.assignments.ct360java.task2and3.controllers;


import com.assignments.ct360java.task2and3.entities.Car;
import com.assignments.ct360java.task2and3.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/get")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer carId){
        return carService.getCarById(carId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Integer carId,
                                                   @RequestBody Car car){
        return carService.getCarById(carId)
                .map(savedCar -> {

                    savedCar.setBrand(car.getBrand());
                    savedCar.setModel(car.getModel());
                    savedCar.setKilometers(car.getKilometers());

                    Car updatedCar = carService.updateCar(savedCar);
                    return new ResponseEntity<>(updatedCar, HttpStatus.OK);

                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Integer carId){

        carService.deleteCar(carId);

        return new ResponseEntity<String>("Car deleted successfully!.", HttpStatus.OK);

    }


}
