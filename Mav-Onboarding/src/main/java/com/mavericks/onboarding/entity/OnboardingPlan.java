package com.mavericks.onboarding.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "onboarding_plans")
public class OnboardingPlan {
    @Id
    @Column(name = "plan_id", length = 20)
    private String planId;
    
    @Column(name = "user_id", length = 20)
    private String userId;
    
    @Column(name = "plan_details", columnDefinition = "TEXT")
    private String planDetails;
    
    @Column(name = "assessment_name", columnDefinition = "TEXT")
    private String assessmentName;
    
    @Column(name = "quiz_name", columnDefinition = "TEXT")
    private String quizName;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    // Constructors
    public OnboardingPlan() {}

    public OnboardingPlan(String planId, String userId, String planDetails, String assessmentName, String quizName) {
        this.planId = planId;
        this.userId = userId;
        this.planDetails = planDetails;
        this.assessmentName = assessmentName;
        this.quizName = quizName;
    }

    // Getters and Setters
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
