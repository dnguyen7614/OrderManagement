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


    private final OrderRepository orderRepo;

    @Autowired
    public OrderService(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    public List<Order>findAllOrders(){
        return orderRepo.findAll();
    }

    public Order findOrderById(Long orderId){
        return orderRepo.findOrderById()
                .orElseThrow(() -> new OrderNotFoundException("Order by id "+ orderId +"was not found"));
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

    public List<Order> filterOrder(String keywords){
        return null;
    }

    public List<Order> sortingOrder(){
        return null;
    }
}
