package org.example.l2s.repository;

import org.example.l2s.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCar_CarId(int carId);
    List<Review> findByUser_UserID(int userId);

}
