package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = Logger.getLogger(OrderController.class.getName());

    //GetMapping to retrieve User by Id from the database
    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
        try {
            logger.info("Get user by id...");
            User user = userService.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //PostMapping to add new User into the database
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try {
            logger.info("adding user to database...");
            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
