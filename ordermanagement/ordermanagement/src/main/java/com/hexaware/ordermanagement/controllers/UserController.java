package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.Product;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = Logger.getLogger(OrderController.class.getName());

    //GetMapping to retrieve User by Id from the database


    @GetMapping("/users/{id}")
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
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try {
            logger.info("adding user to database...");
            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("fail to add user" + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long userid){
        try {
            logger.info("delete user by id...");
            userService.deleteUser(userid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.info("fail to delete user..." + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>>getAllUsers() {

        try {
            logger.info("Get all users...");
            List<User> users = userService.findAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("fail to get list of users" + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
