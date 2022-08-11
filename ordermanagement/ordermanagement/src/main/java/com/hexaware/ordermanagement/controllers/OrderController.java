package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.OrderManagementApplication;
import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.repositories.OrderRepository;
import com.hexaware.ordermanagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    Logger logger = Logger.getLogger(OrderController.class.getName());


    //GetMapping to retrieve Order objects from the database;
    @GetMapping("/orders")
    public ResponseEntity<List<Order>>getAllOrders(){

        try {
            logger.info("Get all orders...");
            List<Order> orders = orderService.findAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("fail to get list of orders" + e);
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //GetMapping to retrieve Order Object by orderId;
    @GetMapping("/orders/{id}")
    public ResponseEntity findById(@PathVariable("id") Long orderId){
        try {
            logger.info("Getting oder by id...");
            Optional<Order> order = orderService.findById(orderId);
            return new ResponseEntity<>(order,HttpStatus.OK);
        } catch (Exception e) {
            logger.info("fail to find order by id" + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //PostMapping to add an Order to the database;
    @PostMapping("/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        System.out.println("add user");
        try{
            logger.info("Adding order to database...");
            System.out.println("try add new user");
            Order newOder = orderService.addNewOrder(order);
            return new ResponseEntity<>(newOder, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("fail to add order" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PutMapping to update an Order to the database;
    @PutMapping("/updateorders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(name = "id") Long id,@RequestBody Order order) {

        logger.info("update order to database...");
        Optional<Order> orderData = orderService.findById(id);
        if (orderData.isPresent()){
            orderData.get().setPrice(order.getPrice());
            orderData.get().setQuantity(order.getQuantity());
            orderData.get().setProduct(order.getProduct());
            orderData.get().setUser(order.getUser());
            Order updateOrder = orderService.updateOrder(orderData.get());
            return new ResponseEntity<Order>(updateOrder, HttpStatus.OK);
        } else {
            logger.info("fail to update order");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //DeleteMapping to delete an Order by using the orderid
    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") Long orderId){
        try {
            logger.info("delete order by id...");
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.info("fail to delete order" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
