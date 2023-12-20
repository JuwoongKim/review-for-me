package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.HashMap;
import java.util.Map;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.Survey;

public record SurveyResponse(
	Long id,
	String title,
	String description,
	Map<Integer, QuestionResponse> questions
) {
	public SurveyResponse(Survey survey) {
		this(
			survey.getId(),
			survey.getTitle(),
			survey.getDescription(),
			change(survey.getQuestions())
		);
	}

	private static Map<Integer, QuestionResponse> change(Map<Integer, Question> questions) {
		Map<Integer, QuestionResponse> questionResponses = new HashMap<>();
		questions.forEach((order, question) -> questionResponses.put(order, new QuestionResponse(question)));

		return questionResponses;
	}

}
