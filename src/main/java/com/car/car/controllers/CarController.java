package com.car.car.controllers;

import com.car.car.entities.Car;
import com.car.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

}
