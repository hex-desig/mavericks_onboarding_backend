package com.mavericks.onboarding.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.mavericks.onboarding.dto.LoginRequest;
import com.mavericks.onboarding.dto.LoginResponse;
import com.mavericks.onboarding.dto.UserCreateRequest;
import com.mavericks.onboarding.entity.JwtUtil;
import com.mavericks.onboarding.entity.User;
import com.mavericks.onboarding.repo.UserRepository;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private  UserRepository userRepository;
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findFirstByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user; 
	}

	@Override
	public UserDetailsService userDetailsService() {

				return this;
	}
}

