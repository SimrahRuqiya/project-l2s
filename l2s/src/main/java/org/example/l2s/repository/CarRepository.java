package org.example.l2s.repository;

import org.example.l2s.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByCarBrand(String brand);
    List<Car> findByCarModel(String model);
    List<Car> findByCarBrandAndCarModel(String brand, String model);
}
