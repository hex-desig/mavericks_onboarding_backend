package com.mavericks.onboarding.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mavericks.onboarding.dto.ApiResponse;
import com.mavericks.onboarding.dto.ProgressUpdateRequest;
import com.mavericks.onboarding.dto.TrainingProgressCreateRequest;
import com.mavericks.onboarding.entity.TrainingProgress;
import com.mavericks.onboarding.serivce.TrainingProgressService;

@RestController
@RequestMapping("/api/v1/training-progress")
public class TrainingProgressController {
	
	private final TrainingProgressService progressService;
	
    public TrainingProgressController(TrainingProgressService progressService) {
        this.progressService = progressService;
    }
    @PostMapping
    public ResponseEntity<ApiResponse<TrainingProgress>> startProgress(
            @Valid @RequestBody TrainingProgressCreateRequest request) {
        TrainingProgress progress = progressService.startProgress(request);
        return ResponseEntity.ok(ApiResponse.success("Progress started", progress));
    }
    @PatchMapping("/{progressId}")
    public ResponseEntity<ApiResponse<TrainingProgress>> updateProgress(
            @PathVariable String progressId,
            @Valid @RequestBody ProgressUpdateRequest updates) {
        TrainingProgress progress = progressService.updateProgress(progressId, updates);
        return ResponseEntity.ok(ApiResponse.success("Progress updated", progress));
    }

}
