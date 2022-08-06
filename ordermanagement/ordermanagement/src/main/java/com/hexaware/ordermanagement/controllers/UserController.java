package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //GetMapping to retrieve User by Id from the database
    @GetMapping("/find/{userid}")
    public ResponseEntity<User> findById(@PathVariable("userid") Long userId){
        try {
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
            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
