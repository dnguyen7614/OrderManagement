package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>>getAll(){

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.FOUND);
    }

    public ResponseEntity<List<Order>>getOrder(@PathParam(value="orderid") Long orderid){
        Optional<Order> orderData = orderService.getOrder(orderid);
        return new ResponseEntity<>(orderData, HttpStatus.OK);
    }

    public ResponseEntity<Order> updateOrder(@PathParam("orderid") long orderid, @RequestBody Order order){
      Optional<Order> orderData = orderService.getOrder(orderid);
      return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.OK);
    }

    public ResponseEntity<Order>createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.CREATED);
    }


}
