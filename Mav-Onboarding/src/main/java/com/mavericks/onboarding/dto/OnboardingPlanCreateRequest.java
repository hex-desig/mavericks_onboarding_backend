package com.mavericks.onboarding.dto;

import javax.validation.constraints.NotBlank;

public class OnboardingPlanCreateRequest {
    @NotBlank
    private String planDetails;

    @NotBlank
    private String assessmentName;

    @NotBlank
    private String quizName;

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public OnboardingPlanCreateRequest( @NotBlank String planDetails,
			@NotBlank String assessmentName, @NotBlank String quizName) {
		super();

		this.planDetails = planDetails;
		this.assessmentName = assessmentName;
		this.quizName = quizName;
	}

	public OnboardingPlanCreateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
