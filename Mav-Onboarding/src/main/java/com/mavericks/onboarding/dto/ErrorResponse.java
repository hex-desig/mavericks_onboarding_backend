package com.mavericks.onboarding.dto;

public record ErrorResponse(int status, String error, String message) {
}
