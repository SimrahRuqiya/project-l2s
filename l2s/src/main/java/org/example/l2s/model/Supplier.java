package org.example.l2s.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//represents the suppliers and includes the average ratings
@Entity
@Table(name = "supplier")
public class Supplier {

    public Supplier() {}

    public Supplier(String supplier_Name, String supplier_Address, String supplier_Contact, double supplier_Rating) {
        supplierName = supplier_Name;
        supplierAddress = supplier_Address;
        supplierContact = supplier_Contact;
        supplierRating = supplier_Rating;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    @Column(unique=true, nullable=false)
    private String supplierName;

    @Column(unique=true, nullable=false)
    private String supplierAddress;

    @Column(unique=true, nullable=false)
    private String supplierContact;

    @Column(unique=false, nullable=false)
    private double supplierRating;

    @OneToMany(mappedBy = "carSupplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierID) {
        this.supplierId = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public double getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(double supplierRating) {
        this.supplierRating = supplierRating;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
