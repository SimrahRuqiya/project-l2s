//Leen Alamm, Leen Abhari, Simrah Shabandri
package org.example.l2s.controller;

import org.example.l2s.model.Review;
import org.example.l2s.model.User;
import org.example.l2s.repository.ReviewRepository;
import org.example.l2s.service.CarService;
import org.example.l2s.service.RentalService;
import org.example.l2s.service.ReviewService;
import org.example.l2s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.saveReview(review)); //sim - will save user review as response
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/car/{carId}")
    public List<Review> getReviewsByCar(@PathVariable int carId) {
        return reviewService.getReviewsByCarId(carId);
    }

    @GetMapping("/form")
    public String showReviewForm(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "review";
    }

    @Autowired
    private RentalService rentalService;

    @PostMapping("/submit")
    public String submitReview(@RequestParam String userName,
                               @RequestParam int carId,
                               @RequestParam int rating,
                               @RequestParam String reviewText,
                               Model model) {

        boolean hasRented = rentalService.existsby(userName, carId);

        if (!hasRented) {
            model.addAttribute("cars", carService.getAllCars());
            model.addAttribute("message", "You can only review cars you have rented.");
            return "review";
        }

        User user = userService.getUserByName(userName); // You need this method

        Review review = new Review();
        review.setUser(user);
        review.setCar(carService.getCarById(carId));
        review.setRating(rating);
        review.setReviewText(reviewText);
        reviewService.saveReview(review);

        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("message", "Review submitted successfully!");
        return "review";
    }

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();

        for (Review review : reviews) {
            int rating = review.getRating();

            List<Integer> starsFilled = new ArrayList<>();
            List<Integer> starsEmpty = new ArrayList<>();

            for (int i = 0; i < rating; i++) {
                starsFilled.add(i);
            }
            for (int i = 0; i < 5 - rating; i++) {
                starsEmpty.add(i);
            }

            review.setStarsFilled(starsFilled);
            review.setStarsEmpty(starsEmpty);
        }

        model.addAttribute("reviews", reviews);

        return "reviews";
    }

}

