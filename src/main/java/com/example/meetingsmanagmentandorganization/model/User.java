package com.example.meetingsmanagmentandorganization.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="username", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name ="email", length = 30, nullable = false, unique = true)
    private String email;

    @Column(name ="password", length = 100, nullable = false)
    private String password;
}
