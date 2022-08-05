package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.exception.OrderNotFoundException;
import com.hexaware.ordermanagement.exception.UserNotFoundException;
import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository repo;

    public User addNewUser(User newUser) {
        return repo.save(newUser);
    }


    public User findUserById(Long userId){
        return repo.findUserById()
                .orElseThrow(() -> new UserNotFoundException("User by id "+ userId +"was not found"));
    }
}
