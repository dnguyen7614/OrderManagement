package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.exception.OrderNotFoundException;
import com.hexaware.ordermanagement.exception.UserNotFoundException;
import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.User;
import com.hexaware.ordermanagement.repositories.OrderRepository;
import com.hexaware.ordermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public OrderService(){

    }

    public List<Order>findAllOrders(){
        return orderRepo.findAll();
    }

    public Optional<Order> findById(Long orderId){
       Optional<Order> order = orderRepo.findById(orderId);
                order
                .orElseThrow(() -> new OrderNotFoundException("Order by id "+ orderId +"was not found"));
        return order;
    }

    public Order addNewOrder(Order newOrder){
        return orderRepo.save(newOrder);
    }

    public Order updateOrder(Order newOrder){
        return orderRepo.save(newOrder);
    }

    public void deleteOrder(Long orderId){
        orderRepo.deleteById(orderId);
    }

}
