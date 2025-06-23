package com.mavericks.onboarding.serivce;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.entity.Register;
import com.mavericks.onboarding.exception.UserAlreadyExistsException;
import com.mavericks.onboarding.repo.RegisterRepo;

@Service
public class RegisterService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(Register register) throws UserAlreadyExistsException {
        // Check if email exists
        if (registerRepo.findByEmail(register.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + register.getEmail() + " already exists");
        }
        // Encode password and set timestamps
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        register.setCreatedAt(Timestamp.from(Instant.now()));
        register.setUpdatedAt(Timestamp.from(Instant.now()));
        // Save user
        registerRepo.save(register);
        
        return "User created successfully";
    }

    public boolean deleteByUsername(String email) {
        Register user = registerRepo.findByEmail(email);
        if (user != null) {
            registerRepo.delete(user);
            return true;
        }
        return false;
    }
}
