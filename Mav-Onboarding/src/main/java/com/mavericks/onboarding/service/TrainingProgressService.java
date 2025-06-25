package com.mavericks.onboarding.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavericks.onboarding.dto.ProgressUpdateRequest;
import com.mavericks.onboarding.dto.TrainingProgressCreateRequest;
import com.mavericks.onboarding.entity.TrainingProgress;
import com.mavericks.onboarding.enums.TrainingStatus;
import com.mavericks.onboarding.repo.TrainingProgressRepository;

@Service
public class TrainingProgressService {

	    private final TrainingProgressRepository progressRepository;
	    private final AuthService authService;
	    
	    @Autowired
	    public TrainingProgressService(TrainingProgressRepository progressRepository,  AuthService authService) {
	        this.progressRepository = progressRepository;
	        this.authService = authService;
	    }

	    public TrainingProgress startProgress(TrainingProgressCreateRequest request) {
	        authService.getUserById(request.userId());
	        
	        TrainingProgress progress = new TrainingProgress();
	        progress.setProgressId(UUID.randomUUID().toString().substring(0, 20));
	        progress.setUserId(request.userId());
	        progress.setTrainingName(request.trainingName());
	        progress.setStatus(TrainingStatus.not_started);
	        
	        return progressRepository.save(progress);
	    }
	    public TrainingProgress updateProgress(String progressId, ProgressUpdateRequest updates) {
	        TrainingProgress progress = progressRepository.findById(progressId)
	                .orElseThrow(() -> new RuntimeException("Progress not found"));
	        
	        if (updates.status() != null) {
	            progress.setStatus(updates.status());
	        }
	        if (updates.score() != null) {
	            progress.setScore(updates.score());
	        }
	        
	        return progressRepository.save(progress);
	    }

}
