package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.field.Field;

public record QuestionResponse(
	Long id,
	String title,
	String description,
	List<FieldResponse> fieldResponses
) {
	public QuestionResponse(Question question) {
		this(
			question.getId(),
			question.getTitle(),
			question.getDescription(),
			change(question.getFields())
		);
	}

	public static List<FieldResponse> change(List<Field> fields) {
		List<FieldResponse> fieldResponses = fields.stream().map(field -> new FieldResponse(field)).toList();

		return fieldResponses;
	}
}
