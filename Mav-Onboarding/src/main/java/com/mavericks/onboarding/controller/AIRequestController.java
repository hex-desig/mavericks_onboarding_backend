package com.mavericks.onboarding.controller;

import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.entity.AIRequest;
import com.mavericks.onboarding.service.AIRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ai-requests")
public class AIRequestController {
    private final AIRequestService aiRequestService;

    public AIRequestController(AIRequestService aiRequestService) {
        this.aiRequestService = aiRequestService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<AIRequest>>> getUserRequests(@PathVariable String userId) {
        List<AIRequest> requests = aiRequestService.getUserRequests(userId);
        return ResponseEntity.ok(ApiResponse.success("Requests retrieved", requests));
    }
}
