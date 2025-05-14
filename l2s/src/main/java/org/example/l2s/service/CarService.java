package org.example.l2s.service;

import jakarta.annotation.PostConstruct;
import org.example.l2s.model.Car;
import org.example.l2s.model.Supplier;
import org.example.l2s.repository.CarRepository;
import org.example.l2s.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    private SupplierRepository supplierRepository;

    public CarService(CarRepository carRepository, SupplierRepository supplierRepository) {
        this.carRepository = carRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByCarBrand(brand);
    }

    public List<Car> getCarsByModel(String model) {
        return carRepository.findByCarModel(model);
    }

    public List<Car> getCarsByBrandAndModel(String brand, String model) {
        return carRepository.findByCarBrandAndCarModel(brand, model);
    }


    
}
