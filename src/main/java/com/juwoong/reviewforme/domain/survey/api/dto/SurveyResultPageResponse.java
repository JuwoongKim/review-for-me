package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

public record SurveyResultPageResponse(
	List<SurveyResultResponse> surveyResponses,
	Integer index,
	boolean hasNext
) {
}
