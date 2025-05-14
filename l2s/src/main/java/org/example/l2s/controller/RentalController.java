//Leen Alamm, Leen Abhari, Simrah Shabandri
package org.example.l2s.controller;

import org.example.l2s.model.Car;
import org.example.l2s.model.Rental;
import org.example.l2s.model.RentalRequest;
import org.example.l2s.model.User;
import org.example.l2s.service.CarService;
import org.example.l2s.service.RentalService;
import org.example.l2s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/rentals")
public class RentalController {


    private final RentalService rentalService;
    private final CarService carService;
    private final UserService userService;

    @Autowired
    public RentalController(RentalService rentalService, CarService carService, UserService userService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<Rental> rentCar(@RequestBody RentalRequest rentalRequest) {
        Rental rental = rentalService.createRental(
                rentalRequest.getUserId(),
                rentalRequest.getCarId(),
                rentalRequest.getStartDate(),
                rentalRequest.getEndDate()
        );
        return ResponseEntity.ok(rental);
    }

    @GetMapping("/book")
    public String showBookingForm(@RequestParam(required = false) int carId, Model model) {
        if (carId != 0) {
            Car selectedCar = carService.getCarById(carId);
            model.addAttribute("selectedCar", selectedCar); // Send selected car to view
        }
        return "booking";

    }

    @PostMapping("/book")
    public String bookRentalFromForm(@RequestParam String userName,
                                     @RequestParam String userContact,
                                     @RequestParam int carId,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                     Model model) {

        User existingUser = userService.findByUserNameAndUserContact(userName, userContact);

        User userToUse;
        if (existingUser != null) {
            userToUse = existingUser;
        } else {
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setUserContact(userContact);
            userToUse = userService.saveUser(newUser);
        }

        Rental rental = rentalService.createRental(userToUse.getUserID(), carId, startDate, endDate);

        model.addAttribute("userName", userToUse.getUserName());
        model.addAttribute("carBrand", rental.getCar().getCarBrand());
        model.addAttribute("carModel", rental.getCar().getCarModel());
        model.addAttribute("startDate", rental.getRentalStartDate());
        model.addAttribute("endDate", rental.getRentalEndDate());
        model.addAttribute("totalPrice", rental.getTotalPrice());
        model.addAttribute("supplierName", rental.getCar().getCarSupplier().getSupplierName());
        model.addAttribute("supplierContact", rental.getCar().getCarSupplier().getSupplierContact());
        model.addAttribute("message", "Booking successful!");

        return "confirmation";
    }


    @GetMapping("/user/{userName}")
    public String showUserRentals(@PathVariable String userName, Model model) {
        model.addAttribute("rentals", rentalService.getRentalsByName(userName));
        return "rentals";
    }


}
