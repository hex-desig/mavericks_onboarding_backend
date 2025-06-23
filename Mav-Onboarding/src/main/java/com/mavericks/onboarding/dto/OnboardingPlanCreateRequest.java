package com.mavericks.onboarding.dto;

public record OnboardingPlanCreateRequest(String userId, String planDetails, String assessmentName, String quizName) {
}
