package com.juwoong.reviewforme.domain.survey.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Answer {

	@Column(name = "content")
	private String content;
}
