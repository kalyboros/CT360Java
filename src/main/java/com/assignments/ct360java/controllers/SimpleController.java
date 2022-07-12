package com.assignments.ct360java.controllers;

import com.assignments.ct360java.models.Car;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping
    public String letMeSolo(){
        return "Let me solo";
    }

    @PostMapping(
            value = "checkCar", consumes = "application/json", produces = "application/json"
    )
    public Car checkCar(@RequestBody Car car) {
        return car;
    }
}
