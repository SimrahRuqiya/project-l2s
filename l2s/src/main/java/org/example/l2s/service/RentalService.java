package org.example.l2s.service;

import org.example.l2s.model.Car;
import org.example.l2s.model.Rental;
import org.example.l2s.model.User;
import org.example.l2s.repository.CarRepository;
import org.example.l2s.repository.RentalRepository;
import org.example.l2s.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;

    public RentalService(RentalRepository rentalRepository, CarRepository carRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public boolean isCarAvailable(int carId, LocalDate startDate, LocalDate endDate) {
        List<Rental> existingRentals = rentalRepository.findByCar_CarId(carId);
        for (Rental rental : existingRentals) {
            if (startDate.isBefore(rental.getRentalEndDate()) && endDate.isAfter(rental.getRentalStartDate())) {
                return false;
            }
        }
        return true;
    }

    public Rental createRental(int userId, int carId, LocalDate startDate, LocalDate endDate) {
        if (!startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }

        if (!isCarAvailable(carId, startDate, endDate)) {
            throw new IllegalStateException("Car is not available for these dates.");
        }

        Car car = carRepository.findById(carId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        Rental rental = new Rental();
        rental.setCar(car);
        rental.setUser(user);
        rental.setRentalStartDate(startDate);
        rental.setRentalEndDate(endDate);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        rental.setTotalPrice(car.getCarPrice() * days);

        return rentalRepository.save(rental);
    }

    public List<Rental> getRentalsByUserId(int userId) {
        return rentalRepository.findByUser_UserID(userId);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public List<Rental> getRentalsByName(String name) {
        return rentalRepository.findByUser_UserName(name);
    }

    public boolean existsby(String userName, int carId) {
        return rentalRepository.existsByUser_UserNameAndCar_CarId(userName, carId);
    }
}
