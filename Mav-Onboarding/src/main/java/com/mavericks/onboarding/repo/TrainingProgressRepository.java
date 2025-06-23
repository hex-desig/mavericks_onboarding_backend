package com.mavericks.onboarding.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericks.onboarding.entity.TrainingProgress;
import com.mavericks.onboarding.enums.TrainingType;

@Repository
public interface TrainingProgressRepository extends JpaRepository<TrainingProgress, String> {
    List<TrainingProgress> findByUserId(String userId);
    Optional<TrainingProgress> findByUserIdAndTrainingName(String userId, TrainingType trainingName);
}