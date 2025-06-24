package com.mavericks.onboarding.controller;

import javax.validation.Valid; // Import for @Valid

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.UserCreateRequest;
import com.mavericks.onboarding.entity.User;
import com.mavericks.onboarding.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser (@Valid @RequestBody UserCreateRequest request) {
        User user = userService.createUser (request);
        return ResponseEntity.ok(ApiResponse.success("User  created", user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<User>> getUser (@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(ApiResponse.success("User  retrieved", user));
    }
}
