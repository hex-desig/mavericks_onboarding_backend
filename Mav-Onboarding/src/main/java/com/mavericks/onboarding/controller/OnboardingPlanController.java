package com.mavericks.onboarding.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.OnboardingPlanCreateRequest;
import com.mavericks.onboarding.entity.OnboardingPlan;
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
            @Valid @RequestBody OnboardingPlanCreateRequest request) {
        OnboardingPlan plan = planService.createPlan(request);
        return ResponseEntity.ok(ApiResponse.success("Plan created", plan));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<OnboardingPlan>>> getUserPlans(@PathVariable String userId) {
        List<OnboardingPlan> plans = planService.getPlansByUser(userId);
        return ResponseEntity.ok(ApiResponse.success("Plans retrieved", plans));
    }
}
