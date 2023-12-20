package com.juwoong.reviewforme.domain.survey.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Option {

	@Column(name = "content")
	private String content;

	protected Option(){
	}
	public Option(String content) {
		this.content = content;
	}
}
