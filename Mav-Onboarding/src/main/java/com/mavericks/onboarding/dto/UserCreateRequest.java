package com.mavericks.onboarding.dto;

import com.mavericks.onboarding.enums.Role; // Ensure this matches the User entity's Role type

public class UserCreateRequest {
    private String name;
    private String email;
    private String password;
    private Role role;

    // Default constructor
    public UserCreateRequest() {}

    // Parameterized constructor
    public UserCreateRequest(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
