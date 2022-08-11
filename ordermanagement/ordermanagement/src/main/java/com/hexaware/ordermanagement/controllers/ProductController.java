package com.hexaware.ordermanagement.controllers;

import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.Product;
import com.hexaware.ordermanagement.repositories.OrderRepository;
import com.hexaware.ordermanagement.repositories.ProductRepository;
import com.hexaware.ordermanagement.services.OrderService;
import com.hexaware.ordermanagement.services.ProductService;
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
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    Logger logger = Logger.getLogger(OrderController.class.getName());


    //GetMapping to retrieve Order objects from the database;
    @GetMapping("/produtcs")
    public ResponseEntity<List<Product>> getAllProducts(){

        try {
            logger.info("Get all products...");
            List<Product> products = productService.findAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("fail to get list of products..." + e);
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //GetMapping to retrieve Order Object by orderId;
    @GetMapping("/products/{id}")
    public ResponseEntity findById(@PathVariable("id") Long proid){
        try {
            logger.info("Getting product by id...");
            Optional<Product> product = productService.findById(proid);
            return new ResponseEntity<>(product,HttpStatus.OK);
        } catch (Exception e) {
            logger.info("fail to get product by id..." + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //PostMapping to add an Order to the database;
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try{
            logger.info("Adding product to database...");
            System.out.println("try add new product");
            Product newProduct = productService.addNewProduct(product);
            System.out.println(product.getProductName());
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("fail to add product..." + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PutMapping to update an Order to the database;
    @PutMapping("/updateproducts/{id}")
    public ResponseEntity<Product> updateOrder(@PathVariable(name = "id") Long id,@RequestBody Product product) {
        logger.info("update product to database...");
        Optional<Product> productData = productService.findById(id);
        if (productData.isPresent()){
            productData.get().setProductName(product.getProductName());
           productData.get().setPrice(product.getPrice());
            productData.get().setProductDesc(product.getProductDesc());
            productData.get().setOrder(product.getOrder());
            Product updateProduct = productService.updateProduct(productData.get());
            return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
        } else {
            logger.info("fail to update product...");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DeleteMapping to delete an Order by using the orderid
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProducut(@PathVariable("id") Long proid){
        try {
            logger.info("delete product by id...");
            productService.deleteProduct(proid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.info("fail to delete product..." + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
