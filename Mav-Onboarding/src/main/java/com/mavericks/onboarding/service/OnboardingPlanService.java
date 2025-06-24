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
    private final OpenAIService openAIService;

    @Autowired
    public OnboardingPlanService(OnboardingPlanRepository planRepository, UserService userService, OpenAIService openAIService) {
        this.planRepository = planRepository;
        this.userService = userService;
        this.openAIService = openAIService;
    }

    public OnboardingPlan createPlan(OnboardingPlanCreateRequest request,String userId) {
        userService.getUserById(userId); // Validate user exists

        // Create a prompt for the OpenAI API to fetch the training plan
        String trainingPlanPrompt = String.format(
            "Create a foundational course training plan suitable for the IT sector for user: %s. " +
            "The user can complete this plan in one month by studying only on weekdays.",
            userId
        );

        // Fetch training plans from OpenAI
        String trainingPlans = openAIService.fetchTrainingPlans(userId, trainingPlanPrompt);

        // Create a prompt for the OpenAI API to fetch the assessment name
        String assessmentPrompt = String.format(
            "Based on the training plan: %s, suggest an appropriate assessment name.",
            trainingPlans
        );

        // Fetch assessment name from OpenAI
        String assessmentName = openAIService.fetchTrainingPlans(userId, assessmentPrompt);

        // Create a prompt for the OpenAI API to fetch the quiz name
        String quizPrompt = String.format(
            "Based on the training plan: %s, suggest an appropriate quiz name.",
            trainingPlans
        );

        // Fetch quiz name from OpenAI
        String quizName = openAIService.fetchTrainingPlans(userId, quizPrompt);

        // Create the OnboardingPlan entity
        OnboardingPlan plan = new OnboardingPlan();
        plan.setPlanId(UUID.randomUUID().toString().substring(0, 20));
        plan.setUserId(userId);
        plan.setPlanDetails(trainingPlans); // Set fetched training plans
        plan.setAssessmentName(assessmentName); // Set fetched assessment name
        plan.setQuizName(quizName); // Set fetched quiz name

        // Save the plan to the repository
        return planRepository.save(plan);
    }

    public List<OnboardingPlan> getPlansByUser (String userId) {
        return planRepository.findByUserId(userId);
    }
}
