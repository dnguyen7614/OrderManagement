package com.hexaware.ordermanagement.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long UserId;

    @NotEmpty(message = "Cannot Be less than 1 character")
    private String firstName;

    @NotEmpty(message = "Cannot Be less than 1 character")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
