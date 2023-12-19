package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.Survey;

public record CreateSurveyRequest(
	String title,
	String description
) {
	public Survey toEntity() {
		return new Survey(title, description);
	}
}
