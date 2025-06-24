package com.mavericks.onboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mavericks.onboarding.entity.AIRequest;

@Service
public class OpenAIService {
    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    private final String API_KEY = "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"; // Use environment variable in production
    private final AIRequestService aiRequestService;

    @Autowired
    public OpenAIService(AIRequestService aiRequestService) {
        this.aiRequestService = aiRequestService;
    }

    public String fetchTrainingPlans(String userId, String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        // Create request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        String requestBody = String.format("""
            {
                "model": "gpt-4o-mini",
                "store": true,
                "messages": [
                    {"role": "user", "content": "%s"}
                ]
            }
            """, prompt);

        // Create the request entity
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Track the request
        AIRequest aiRequest = aiRequestService.createRequest(
            userId,
            AIRequest.AIRequestType.onboarding,
            requestBody,
            null
        );

        try {
            // Make the API call
            ResponseEntity<String> response = restTemplate.exchange(
                OPENAI_API_URL,
                HttpMethod.POST,
                requestEntity,
                String.class
            );

            // Update with response
            aiRequest.setResponsePayload(response.getBody());
            aiRequestService.updateRequest(aiRequest);

            return response.getBody();
        } catch (Exception e) {
            aiRequest.setResponsePayload("Error: " + e.getMessage());
            aiRequestService.updateRequest(aiRequest);
            throw new RuntimeException("Failed to fetch training plans", e);
        }
    }
}
