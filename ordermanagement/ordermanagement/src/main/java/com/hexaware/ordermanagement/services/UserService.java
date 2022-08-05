package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user){
        repo.save(user);
        return user;
    }

    public Optional<User> getUser(Long userId){
        return repo.findById(userId);
    }
}
