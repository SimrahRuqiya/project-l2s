package org.example.l2s.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//represents a person who is renting cars through the platform
//will b connected to a rental + review
@Entity
@Table(name = "user")
public class User {

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    @Column(unique = true, nullable = false)
    private String userName;
    private String userContact;

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
