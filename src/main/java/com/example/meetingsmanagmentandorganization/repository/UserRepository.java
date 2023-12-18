package com.example.meetingsmanagmentandorganization.repository;

import com.example.meetingsmanagmentandorganization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    ArrayList<User> findAll();
    User findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    Boolean existsUserByUsername(String username);
    Boolean existsUserByEmail(String email);
}
