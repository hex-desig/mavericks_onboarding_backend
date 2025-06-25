package com.mavericks.onboarding.service;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {
	UserDetailsService userDetailsService();
}