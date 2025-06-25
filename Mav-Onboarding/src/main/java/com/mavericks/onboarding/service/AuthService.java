package com.mavericks.onboarding.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.dto.LoginRequest;
import com.mavericks.onboarding.dto.LoginResponse;
import com.mavericks.onboarding.dto.UserCreateRequest;
import com.mavericks.onboarding.entity.JwtUtil;
import com.mavericks.onboarding.entity.Register;
import com.mavericks.onboarding.entity.User;
import com.mavericks.onboarding.repo.RegisterRepo;
import com.mavericks.onboarding.repo.UserRepository;

@Service
public class AuthService {
	
	@Autowired
    private RegisterRepo registerRepo;
	@Autowired
    private UserRepository userRepo;
	  
	  
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private UserService userService;
	     
	    @Autowired
	    private JwtUtil jwtUtil;

	   
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean authenticate(String email, String password) {
        Register user = registerRepo.findByEmail(email);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
    public boolean hasCustomerWithEmail(String email) {
    	return userRepo.findFirstByEmail(email).isPresent();
    }
 

    public User createUser (UserCreateRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().substring(0, 20));
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setRole(request.getRole()); // Ensure this matches the User entity's Role type
        
        return userRepo.save(user);
    }

    public User getUserById(String userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User  not found"));
    }
    
    public LoginResponse login(LoginRequest authRequest) {
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
    				authRequest.getPassword()));
    	} catch (BadCredentialsException e) {
    		throw new BadCredentialsException("Incorrect Email Or Password.");
    	}

    	UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authRequest.getEmail());
    	String jwt = jwtUtil.generateToken(userDetails);

    	LoginResponse response = new LoginResponse();
    	Optional<User> user = userRepo.findFirstByEmail(userDetails.getUsername());
    	if (user.isPresent()) {
    		response.setJwt(jwt);
    		response.setUserId(user.get().getUserId());
    		response.setRole(user.get().getRole());
    	}
    	return response;
    }

    public void deleteUser (String userId) {
        if (!userRepo.existsById(userId)) {
            throw new RuntimeException("User  not found");
        }
        userRepo.deleteById(userId);
    }

}
