package org.example.l2s.repository;

import org.example.l2s.model.Rental;
import org.example.l2s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findByCar_CarId(int carId);
    List<Rental> findByUser_UserID(int userId);
    List<Rental> findByUser_UserName(String name);
    boolean existsByUser_UserNameAndCar_CarId(String userName, int carId);

}
