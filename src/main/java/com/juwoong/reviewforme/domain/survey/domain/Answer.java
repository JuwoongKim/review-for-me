package com.juwoong.reviewforme.domain.survey.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Answer {

	@Column(name = "fieldId_id")
	private Long fieldId;

	@Column(name = "content")
	private String content;

	protected Answer() {
	}

	public Answer(Long fieldId, String content) {
		this.fieldId = fieldId;
		this.content = content;
	}
}
