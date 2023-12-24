package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

public record SurveyResultByReviewerPagingResponse(
	List<SurveyResultResponse> surveyResponses,
	Integer index,
	boolean hasNext
) {
}
