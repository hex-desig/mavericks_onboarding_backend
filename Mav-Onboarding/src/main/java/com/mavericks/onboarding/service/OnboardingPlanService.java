package com.mavericks.onboarding.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.dto.OnboardingPlanCreateRequest;
import com.mavericks.onboarding.entity.OnboardingPlan;
import com.mavericks.onboarding.repo.OnboardingPlanRepository;

@Service
public class OnboardingPlanService {
	private final OnboardingPlanRepository planRepository;
    private final UserService userService;
    
    @Autowired
    public OnboardingPlanService(OnboardingPlanRepository planRepository, UserService userService) {
        this.planRepository = planRepository;
        this.userService = userService;
    }

    public OnboardingPlan createPlan(OnboardingPlanCreateRequest request) {
        userService.getUserById(request.userId()); // Validate user exists
        
        OnboardingPlan plan = new OnboardingPlan();
        plan.setPlanId(UUID.randomUUID().toString().substring(0, 20));
        plan.setUserId(request.userId());
        plan.setPlanDetails(request.planDetails());
        plan.setAssessmentName(request.assessmentName());
        plan.setQuizName(request.quizName());
        
        return planRepository.save(plan);
    }
    public List<OnboardingPlan> getPlansByUser(String userId) {
        return planRepository.findByUserId(userId);
    }
}
