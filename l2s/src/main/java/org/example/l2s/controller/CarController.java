//Leen Alamm, Leen Abhari, Simrah Shabandri
package org.example.l2s.controller;

import org.example.l2s.model.Car;
import org.example.l2s.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this controller will route to show all the available cars, search specific car, view details of car
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/id/{id}")
    public Car getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @GetMapping("/model/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.getCarsByBrand(brand);
    }

    @GetMapping("/brand/{brand}/model/{model}")
    public List<Car> getCarsByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return carService.getCarsByBrandAndModel(brand, model);
    }

}
