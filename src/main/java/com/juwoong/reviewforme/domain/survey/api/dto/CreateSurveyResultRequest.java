package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.SurveyResult;

public record CreateSurveyResultRequest(
	String reviewerName
) {
	public SurveyResult toEntity() {
		return new SurveyResult(reviewerName);
	}
}
