package com.hexaware.ordermanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
    private Double price;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    private boolean orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
