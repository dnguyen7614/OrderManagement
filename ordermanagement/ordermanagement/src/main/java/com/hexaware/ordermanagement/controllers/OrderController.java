package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/allorder")
    public ResponseEntity<List<Order>>getAllOrders(){
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{orderid}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId){
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order newOder = orderService.addNewOrder(order);
        return new ResponseEntity<>(newOder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @PutMapping("/delete/{orderid}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
