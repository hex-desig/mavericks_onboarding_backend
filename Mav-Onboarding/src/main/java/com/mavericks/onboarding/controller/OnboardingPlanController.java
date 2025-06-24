package com.mavericks.onboarding.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.OnboardingPlanCreateRequest;
import com.mavericks.onboarding.entity.OnboardingPlan;
import com.mavericks.onboarding.entity.User; // Assuming you have a User entity
import com.mavericks.onboarding.service.OnboardingPlanService;

@RestController
@RequestMapping("/api/v1/onboarding-plans")
public class OnboardingPlanController {
    private final OnboardingPlanService planService;

    public OnboardingPlanController(OnboardingPlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OnboardingPlan>> createPlan(
            @AuthenticationPrincipal User user, // Get the authenticated user
            @Valid @RequestBody OnboardingPlanCreateRequest request) {
        
        // Set the userId in the request based on the authenticated user
        String userId = user.getUserId(); // Assuming User has a getUser Id() method
        OnboardingPlan plan = planService.createPlan(request, userId); // Pass userId to the service
        return ResponseEntity.ok(ApiResponse.success("Plan created", plan));
    }


    @GetMapping("/user")
    public ResponseEntity<ApiResponse<List<OnboardingPlan>>> getUserPlans(@AuthenticationPrincipal User user) {
        // Retrieve plans for the authenticated user
        List<OnboardingPlan> plans = planService.getPlansByUser (user.getUserId());
        return ResponseEntity.ok(ApiResponse.success("Plans retrieved", plans));
    }
}
