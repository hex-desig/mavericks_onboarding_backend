package com.mavericks.onboarding.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mavericks.onboarding.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {
    List<Quiz> findByUserId(String userId);
}