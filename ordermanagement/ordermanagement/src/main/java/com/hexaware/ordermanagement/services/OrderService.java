package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order saveOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Long orderid) {
        return orderRepository.findById(orderid);
    }
}
