package com.assignments.ct360java.task2and3.repos;

import com.assignments.ct360java.task2and3.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
