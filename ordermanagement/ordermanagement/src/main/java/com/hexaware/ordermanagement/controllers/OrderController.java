package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    //GetMapping to retrieve Order objects from the database;
    @GetMapping("/all")
    public ResponseEntity<List<Order>>getAllOrders(){
        try {
            List<Order> orders = orderService.findAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //GetMapping to retrieve Order Object by orderId;
    @GetMapping("/find/{id}")
    public ResponseEntity getOrderById(@PathVariable("orderId") Long orderId){
        try {
            Optional<Order> order = orderService.findById(orderId);
            return new ResponseEntity<>(order,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //PostMapping to add an Order to the database;
    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        try{
            Order newOder = orderService.addNewOrder(order);
            return new ResponseEntity<>(newOder, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PutMapping to update an Order to the database;
    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {

        Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    //DeleteMapping to delete an Order by using the orderid
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderid") Long orderId){

        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
