package com.mavericks.onboarding.controller;

import javax.validation.Valid; // Import for @Valid

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.LoginRequest;
import com.mavericks.onboarding.dto.LoginResponse;
import com.mavericks.onboarding.dto.UserCreateRequest;
import com.mavericks.onboarding.entity.User;
import com.mavericks.onboarding.service.AuthService;
import com.mavericks.onboarding.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {











	@Autowired
    private  AuthService authService;
	@Autowired
    private  UserService userService;

	@PostMapping("/api/auth/signup")
	public ResponseEntity<?> signupCustomer(@RequestBody UserCreateRequest signupRequest) {
	    try {
	        System.out.println("Signup request received: " + signupRequest);
	        // Log the role to ensure it is being set correctly
	        System.out.println("Role received: " + signupRequest.getRole());

	        if (authService.hasCustomerWithEmail(signupRequest.getEmail())) {
	            return new ResponseEntity<>("Customer already exists", HttpStatus.NOT_ACCEPTABLE);
	        }

	        User createdCustomerDto = authService.createUser(signupRequest);

	        if (createdCustomerDto == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
	    } catch (Exception e) {
	        System.err.println("Error during signup: " + e.getMessage());
	        e.printStackTrace();
	        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

  
	
	
	
	
	
	


	





    
    
   

    @GetMapping("/admin/getUser/{userId}")
    public ResponseEntity<ApiResponse<User>> getUser (@PathVariable String userId) {
        User user = authService.getUserById(userId);
        return ResponseEntity.ok(ApiResponse.success("User retrieved", user));
    }
    
@PostMapping("/api/auth/login")
public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest authenticationRequest) {
    try {
        LoginResponse response = authService.login(authenticationRequest);
        return ResponseEntity.ok(response);
    } catch (BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
    }
}
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser (@PathVariable String userId) {
        authService.deleteUser (userId);
        return ResponseEntity.ok(ApiResponse.success("User  deleted successfully", null));
    }
    
    @GetMapping("/fresher/test")
    public ResponseEntity<String> testEndpoint(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok("Authenticated user: " + user.getEmail());
    }

}
