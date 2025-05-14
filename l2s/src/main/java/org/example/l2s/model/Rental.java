package org.example.l2s.model;

import jakarta.persistence.*;

import java.time.LocalDate;

//tracks the rental booking for users
@Entity
@Table(name = "rental")
public class Rental {

    public Rental() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rentalID;
    private float totalPrice;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;


    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    @ManyToOne(optional = false) // Each rental must have a user
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @ManyToOne(optional = false) // Each rental must have a car
    @JoinColumn(name = "Car_ID", nullable = false)
    private Car car;

}
