package com.jyothi.StudentManagementSystem.search.service;

import com.jyothi.StudentManagementSystem.config.CustomUserDetails;
import com.jyothi.StudentManagementSystem.entities.User;
import com.jyothi.StudentManagementSystem.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("🔐 [LOGIN] Attempting to load user: {}", username);

        //User user = userRepo.findByUsername(username)
        return userRepo.findByUsername(username)
                .map(user -> {
                    log.info("✅ [LOGIN] User found: {}", user.getUsername());
                    return new CustomUserDetails(user);
                })
                .orElseThrow(()->{
                    log.error("❌ [LOGIN] Username not found in DB: {}", username);
                     return new UsernameNotFoundException("user not found");
                });
        //return new CustomUserDetails(user);
    }

    @PostConstruct
    public void init() {
        log.info("✅ CustomUserDetailsService initialized");
    }
}
