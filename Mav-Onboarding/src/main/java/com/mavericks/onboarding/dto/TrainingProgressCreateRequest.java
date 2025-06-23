package com.mavericks.onboarding.dto;

import com.mavericks.onboarding.enums.TrainingType;

public record TrainingProgressCreateRequest(String userId, TrainingType trainingName) {
}
