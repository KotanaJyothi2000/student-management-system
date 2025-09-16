package com.jyothi.StudentManagementSystem.repository;

import com.jyothi.StudentManagementSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {


    Optional<User> findByUsername(String username);

    //returns true if username already exists
    boolean existsByUsername(String username);
}
