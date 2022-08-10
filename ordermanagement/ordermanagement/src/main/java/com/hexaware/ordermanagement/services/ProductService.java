package com.hexaware.ordermanagement.services;

import com.hexaware.ordermanagement.exception.OrderNotFoundException;
import com.hexaware.ordermanagement.models.Order;
import com.hexaware.ordermanagement.models.Product;
import com.hexaware.ordermanagement.repositories.OrderRepository;
import com.hexaware.ordermanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public ProductService(){

    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Product> findById(Long proid){
        Optional<Product> product = productRepo.findById(proid);
        product
                .orElseThrow(() -> new OrderNotFoundException("Product by id "+ proid +"was not found"));
        return product;
    }

    public Product addNewProduct(Product newProduct){
        return productRepo.save(newProduct);
    }

    public Product updateProduct(Product newProduct){
        return productRepo.save(newProduct);
    }

    public void deleteProduct(Long proid){
        productRepo.deleteById(proid);
    }
}
