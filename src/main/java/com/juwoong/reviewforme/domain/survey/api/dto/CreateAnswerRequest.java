package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.Answer;

public record CreateAnswerRequest(
	Long fieldId,
	String content
) {

	public Answer toValue() {
		return new Answer(fieldId, content);
	}
}
