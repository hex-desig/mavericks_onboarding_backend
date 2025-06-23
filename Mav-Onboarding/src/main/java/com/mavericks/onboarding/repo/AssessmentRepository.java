package com.mavericks.onboarding.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericks.onboarding.entity.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String> {
    List<Assessment> findByUserId(String userId);
}