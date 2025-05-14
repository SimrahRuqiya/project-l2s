package org.example.l2s.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "review")
public class Review {

    public Review() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewID;
    @Column(name = "review_text", nullable = false)
    private String reviewText;
    @Column(name = "review_rating", nullable = false)
    private int rating;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ElementCollection
    private List<Integer> starsFilled;
    @ElementCollection
    private List<Integer> starsEmpty;

    public List<Integer> getStarsFilled() {
        return starsFilled;
    }

    public void setStarsFilled(List<Integer> starsFilled) {
        this.starsFilled = starsFilled;
    }

    public List<Integer> getStarsEmpty() {
        return starsEmpty;
    }

    public void setStarsEmpty(List<Integer> starsEmpty) {
        this.starsEmpty = starsEmpty;
    }


    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
}
