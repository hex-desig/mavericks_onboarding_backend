package com.mavericks.onboarding.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @Column(name = "quiz_id", length = 20)
    private String quizId;
    
    @Column(name = "user_id", length = 20)
    private String userId;
    
    @Column(name = "quiz_name", length = 100)
    private String quizName;
    
    @Column(name = "quiz_questions", columnDefinition = "TEXT")
    private String quizQuestions;
    
    @Column(name = "submission_date")
    private Timestamp submissionDate;
    
    @Column(precision = 5, scale = 2)
    private Double score;
    
    @Column(columnDefinition = "TEXT")
    private String feedback;

    // Constructors
    public Quiz() {}

    public Quiz(String quizId, String userId, String quizName) {
        this.quizId = quizId;
        this.userId = userId;
        this.quizName = quizName;
        this.submissionDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(String quizQuestions) {
        this.quizQuestions = quizQuestions;
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
