package com.mavericks.onboarding.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "ai_requests")
public class AIRequest {
    @Id
    @Column(name = "request_id")
    private String requestId;

    @Column(name = "user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "request_type")
    private AIRequestType requestType;

    @Column(name = "request_payload")
    private String requestPayload;

    @Column(name = "response_payload")
    private String responsePayload;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    // Enums
    public enum AIRequestType {
        onboarding, assessment, reporting, quiz, certifications
    }

    // Constructors, Getters and Setters
    public AIRequest() {}

    public AIRequest(String requestId, String userId, AIRequestType requestType, 
                   String requestPayload, String responsePayload) {
        this.requestId = requestId;
        this.userId = userId;
        this.requestType = requestType;
        this.requestPayload = requestPayload;
        this.responsePayload = responsePayload;
    }

    // Getters and Setters...
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AIRequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(AIRequestType requestType) {
        this.requestType = requestType;
    }

    public String getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    public String getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(String responsePayload) {
        this.responsePayload = responsePayload;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
