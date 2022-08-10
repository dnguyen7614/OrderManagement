package com.hexaware.ordermanagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long proid;

    @Column(name = "productName", nullable = false)
    @Length(min = 5)
    private String productName;

    @Column(name = "price", nullable = false)
    @DecimalMin("10000") @DecimalMin("1")
    private double price;

    @Column(name = "productDescription", nullable = false)
    @Length(min = 5)
    private String productDesc;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
