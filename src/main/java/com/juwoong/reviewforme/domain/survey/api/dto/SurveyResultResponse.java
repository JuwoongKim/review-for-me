package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Answer;
import com.juwoong.reviewforme.domain.survey.domain.SurveyResult;

public record SurveyResultResponse(
	Long surveyResultId,
	String reviewerName,
	List<AnswerResponse> answerResponses
) {
	public SurveyResultResponse(SurveyResult surveyResult) {
		this(
			surveyResult.getId(),
			surveyResult.getReviewerName(),
			change(surveyResult.getAnswers())
		);
	}

	public static List<AnswerResponse> change(List<Answer> answers) {
		List<AnswerResponse> answerResponses = answers.stream()
			.map(answer -> new AnswerResponse(answer))
			.toList();

		return answerResponses;
	}
}
