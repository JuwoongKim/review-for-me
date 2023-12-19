package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.Map;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.Survey;

public record SurveyResponse(
	Long id,
	String title,
	String description,
	Map<Integer, Question> questions
) {
	public SurveyResponse(Survey survey) {
		this(
			survey.getId(),
			survey.getTitle(),
			survey.getTitle(),
			survey.getQuestions()
		);
	}
}
