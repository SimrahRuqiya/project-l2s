package org.example.l2s.repository;

import org.example.l2s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String email);

    User findByUserNameAndUserContact(String userName, String userContact);

}
