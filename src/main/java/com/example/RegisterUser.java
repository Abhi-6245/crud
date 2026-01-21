package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {
   private Logger log  =LoggerFactory.getLogger(RegisterUser.class);
    public void registerUser(String username) {
        log.trace("Entering registerUser method with username: {}", username);

        if (username == null || username.isEmpty()) {
            log.warn("Username is empty or null!");
            return;
        }

        log.debug("Checking if username {} is already taken...", username);

        if ("admin".equalsIgnoreCase(username)) {
            log.error("Registration failed: Username '{}' is reserved!", username);
            return;
        }

        log.info("User '{}' registered successfully!", username);
        log.trace("Exiting registerUser method...");
    }
    public void getUserDetails(String username) {
        log.trace("Entering getUserDetails method for username: {}", username);

        if ("testUser".equalsIgnoreCase(username)) {
            log.debug("Fetching details for test user.");
            log.info("User details found for '{}'", username);
        } else {
            log.warn("User '{}' not found in the system!", username);
        }

        log.trace("Exiting getUserDetails method...");
    }


}

