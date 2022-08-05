package com.hexaware.ordermanagement.repositories;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findUserById();
}
