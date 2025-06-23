package com.mavericks.onboarding.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericks.onboarding.entity.OnboardingPlan;

@Repository
public interface OnboardingPlanRepository extends JpaRepository<OnboardingPlan, String> {
    List<OnboardingPlan> findByUserId(String userId);
}