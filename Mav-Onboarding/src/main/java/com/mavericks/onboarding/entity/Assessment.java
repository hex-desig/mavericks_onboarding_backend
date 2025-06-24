package com.mavericks.onboarding.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assessments")
public class Assessment {
    @Id
    @Column(name = "assessment_id", length = 20)
    private String assessmentId;
    
    @Column(name = "user_id", length = 20)
    private String userId;
    
    @Column(name = "assessment_name", length = 100)
    private String assessmentName;
    
    @Column(name = "assessment_questions", columnDefinition = "TEXT")
    private String assessmentQuestions;
    
    @Column(name = "submission_date")
    private Timestamp submissionDate;
    
    @Column(name = "score")
    private Double score;
    
    @Column(name = "feedback")
    private String feedback;

    // Constructors
    public Assessment() {}

    public Assessment(String assessmentId, String userId, String assessmentName) {
        this.assessmentId = assessmentId;
        this.userId = userId;
        this.assessmentName = assessmentName;
        this.submissionDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentQuestions() {
        return assessmentQuestions;
    }

    public void setAssessmentQuestions(String assessmentQuestions) {
        this.assessmentQuestions = assessmentQuestions;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
