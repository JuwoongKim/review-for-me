package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.Answer;

public record AnswerResponse(
	Long fieldId,
	String content
) {

	public AnswerResponse(Answer answer) {
		this(
			answer.getFieldId(),
			answer.getContent()
		);
	}
}
