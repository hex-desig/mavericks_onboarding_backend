package com.mavericks.onboarding.repo;

import com.mavericks.onboarding.entity.AIRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIRequestRepository extends JpaRepository<AIRequest, String> {
    List<AIRequest> findByUserId(String userId);
    List<AIRequest> findByRequestType(AIRequest.AIRequestType requestType);
}
