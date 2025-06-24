package com.mavericks.onboarding.controller;

import javax.validation.Valid; // Import for @Valid

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.JwtUtil;
import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.LoginRequest;
import com.mavericks.onboarding.dto.UserCreateRequest;
import com.mavericks.onboarding.entity.User;
import com.mavericks.onboarding.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    public UserController(UserService userService,JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser (@Valid @RequestBody UserCreateRequest request) {
        User user = userService.createUser (request);
        return ResponseEntity.ok(ApiResponse.success("User created", user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<User>> getUser (@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(ApiResponse.success("User retrieved", user));
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
     // Generate token
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(ApiResponse.success("Login successful", token));
    }
    
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse<String>> deleteUser (@PathVariable String userId) {
        userService.deleteUser (userId);
        return ResponseEntity.ok(ApiResponse.success("User  deleted successfully", null));
    }
    
    @GetMapping("/api/v1/test")
    public ResponseEntity<String> testEndpoint(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok("Authenticated user: " + user.getEmail());
    }

}
