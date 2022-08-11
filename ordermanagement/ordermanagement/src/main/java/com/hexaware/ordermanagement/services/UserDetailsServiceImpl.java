package com.hexaware.ordermanagement.services;


import com.hexaware.ordermanagement.exception.EmailNotFoundException;
import com.hexaware.ordermanagement.exception.UserNotFoundException;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByEmail(String email) throws EmailNotFoundException {
        User user = userRepository.findUserByEmail(email).orElseThrow(() ->
        new UserNotFoundException("User Not Found with email: " + email));
        return UserDetailsImpl.build(user);
    }

}
