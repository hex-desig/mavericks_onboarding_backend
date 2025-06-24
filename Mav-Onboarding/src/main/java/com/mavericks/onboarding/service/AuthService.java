package com.mavericks.onboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.mavericks.onboarding.entity.Register;
import com.mavericks.onboarding.repo.RegisterRepo;

@Service
public class AuthService {
	
	@Autowired
    private RegisterRepo registerRepo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean authenticate(String email, String password) {
        Register user = registerRepo.findByEmail(email);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

}
