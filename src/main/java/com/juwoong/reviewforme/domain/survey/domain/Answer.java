package com.juwoong.reviewforme.domain.survey.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Answer {

	@Column(name = "item_id")
	private Long fieldId;

	@Column(name = "content")
	private String content;
}
