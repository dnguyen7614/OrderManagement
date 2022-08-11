package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.exception.UserNotFoundException;
import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserService(){

    }

    public User addNewUser(User newUser) {
        return repo.save(newUser);
    }

    public User findById(Long userId){
        return repo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User by id "+ userId +"was not found"));
    }
    public User updateUser(User newUser){
        return repo.save(newUser);
    }

    public void deleteUser(Long userId){
        repo.deleteById(userId);
    }

    public List<User> findAllUsers(){
        return repo.findAll();
    }
}
