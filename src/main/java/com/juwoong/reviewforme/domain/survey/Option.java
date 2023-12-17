package com.juwoong.reviewforme.domain.survey;

import jakarta.persistence.Embeddable;

@Embeddable
public class Option {

	String contents;

	public Option() {
	}

	public Option(String contents) {
		this.contents = contents;
	}

}
