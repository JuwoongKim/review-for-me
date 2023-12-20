package com.juwoong.reviewforme.domain.survey.api.dto;

import com.juwoong.reviewforme.domain.survey.domain.Option;

public record CreateOptionRequest(
	String content
) {

	public Option toValue() {
		return new Option(this.content);
	}
}
