package com.mavericks.onboarding.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.entity.AIRequest;
import com.mavericks.onboarding.repo.AIRequestRepository;

@Service
public class AIRequestService {
    private final AIRequestRepository aiRequestRepository;

    @Autowired
    public AIRequestService(AIRequestRepository aiRequestRepository) {
        this.aiRequestRepository = aiRequestRepository;
    }

    public AIRequest createRequest(String userId, AIRequest.AIRequestType requestType, 
                                 String requestPayload, String responsePayload) {
        AIRequest request = new AIRequest();
        request.setRequestId(generateRequestId());
        request.setUserId(userId);
        request.setRequestType(requestType);
        request.setRequestPayload(requestPayload);
        request.setResponsePayload(responsePayload);
        
        return aiRequestRepository.save(request);
    }

    public List<AIRequest> getUserRequests(String userId) {
        return aiRequestRepository.findByUserId(userId);
    }

    private String generateRequestId() {
        return UUID.randomUUID().toString().substring(0, 20);
    }
    
    public AIRequest updateRequest(AIRequest request) {
        return aiRequestRepository.save(request);
    }

}
