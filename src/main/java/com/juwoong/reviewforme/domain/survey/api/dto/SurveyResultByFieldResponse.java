package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.SurveyResult;

public record SurveyResultByFieldResponse(
	Long fieldId,
	String reviewerName,
	String content
) {

	public SurveyResultByFieldResponse(SurveyResult.ByField surveyResultByField) {
		this(
			surveyResultByField.getFieldId(),
			surveyResultByField.getReviewerName(),
			surveyResultByField.getContent()
		);
	}
}
