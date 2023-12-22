package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.field.Field;

public record CreateQuestionRequest(
	Long questionId,
	Integer questionOrder,
	String questionTitle,
	String questionDescription,
	List<CreateFieldRequest> questionFields
) {
	public Question toEntity() {
		List<Field> fields = questionFields.stream().map(request -> request.toEntity()).toList();

		return new Question(questionId, questionTitle, questionDescription, fields);
	}
}
