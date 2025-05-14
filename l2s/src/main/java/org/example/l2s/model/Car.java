package org.example.l2s.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//represents each car available for rental on the platform
//linked to a supplier
@Entity
@Table(name = "car")
public class Car {

    public Car() {}

    public Car(String car_Brand, String car_Model, int car_Price, String car_Condition, boolean car_Availability, Supplier carSupplier, String car_Path) {
        carBrand = car_Brand;
        carModel = car_Model;
        carPrice = car_Price;
        carCondition = car_Condition;
        carAvailability = car_Availability;
        this.carSupplier = carSupplier;
        carImagePath = car_Path;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(unique = false, nullable = false)
    private String carBrand;

    @Column(unique = false, nullable = false)
    private String carModel;

    @Column(unique = false, nullable = false)
    private int carPrice; //per day

    @Column(unique = false, nullable = false)
    private String carCondition;

    @Column(unique = false, nullable = false)
    private boolean carAvailability;

    @Column(unique = false, nullable = false)
    private String carImagePath;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonIgnore
    private Supplier carSupplier;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carID) {
        this.carId = carID;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }

    public boolean isCarAvailability() {
        return carAvailability;
    }

    public void setCarAvailability(boolean carAvailability) {
        this.carAvailability = carAvailability;
    }

    public Supplier getCarSupplier() {
        return carSupplier;
    }

    public void setCarSupplier(Supplier car_Supplier) {
        this.carSupplier = car_Supplier;
    }

    public void setCarImagePath(String carImagePath) {
        this.carImagePath = carImagePath;
    }

    public String getCarImagePath() {
        return carImagePath;
    }

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

}