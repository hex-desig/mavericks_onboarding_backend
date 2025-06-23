package com.mavericks.onboarding.dto;

import com.mavericks.onboarding.enums.TrainingStatus;

public record ProgressUpdateRequest(TrainingStatus status, Double score) {}
