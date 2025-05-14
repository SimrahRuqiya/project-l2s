package org.example.l2s.service;

import org.example.l2s.model.User;
import org.example.l2s.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    public User getUserByName(String name) {
        return userRepository.findByUserName(name);
    }

    public User findByUserNameAndUserContact(String userName, String userContact) {
        return userRepository.findByUserNameAndUserContact(userName, userContact);
    }

}
