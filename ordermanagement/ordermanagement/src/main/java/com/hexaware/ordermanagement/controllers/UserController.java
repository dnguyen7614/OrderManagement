package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(new User()), HttpStatus.CREATED);
    }

    public ResponseEntity<List<User>>getUser(@PathParam(value="userid") Long userid){
        Optional<User> user = userService.getUser(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
