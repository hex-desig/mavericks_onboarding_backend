package com.mavericks.onboarding.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import com.mavericks.onboarding.enums.TrainingStatus;
import com.mavericks.onboarding.enums.TrainingType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "training_progress")
public class TrainingProgress {
    @Id
    @Column(name = "progress_id", length = 20)
    private String progressId;
    
    @Column(name = "user_id", length = 20)
    private String userId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "training_name")
    private TrainingType trainingName;
    
    @Column(name = "foundation_module_name", columnDefinition = "TEXT")
    private String foundationModuleName;
    
    @Column(name = "technical_module_name", columnDefinition = "TEXT")
    private String technicalModuleName;
    
    @Enumerated(EnumType.STRING)
    private TrainingStatus status;
    
    @Column(precision = 5, scale = 2)
    private Double score;
    
    @UpdateTimestamp
    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    // Constructors
    public TrainingProgress() {}

    public TrainingProgress(String progressId, String userId, TrainingType trainingName) {
        this.progressId = progressId;
        this.userId = userId;
        this.trainingName = trainingName;
        this.status = TrainingStatus.not_started;
    }

    // Getters and Setters
    public String getProgressId() {
        return progressId;
    }

    public void setProgressId(String progressId) {
        this.progressId = progressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TrainingType getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(TrainingType trainingName) {
        this.trainingName = trainingName;
    }

    public String getFoundationModuleName() {
        return foundationModuleName;
    }

    public void setFoundationModuleName(String foundationModuleName) {
        this.foundationModuleName = foundationModuleName;
    }

    public String getTechnicalModuleName() {
        return technicalModuleName;
    }

    public void setTechnicalModuleName(String technicalModuleName) {
        this.technicalModuleName = technicalModuleName;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
