package com.hexaware.ordermanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "Product", nullable = false)
    private String product;

    @Column(name = "Price", nullable = false)
    @DecimalMax("10000") @DecimalMin("1")
    private Double price;

    @Column(name = "Quantity", nullable = false)
    @DecimalMax("10") @DecimalMin("1")
    private Integer quantity;


    @Column(name = "OrderStatus", nullable = false)
    private String OrderStatus;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
