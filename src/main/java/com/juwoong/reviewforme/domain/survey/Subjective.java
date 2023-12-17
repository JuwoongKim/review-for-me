package com.juwoong.reviewforme.domain.survey;

import jakarta.persistence.Entity;

@Entity
public class Subjective extends Question{

	protected Subjective() {
	}

	public Subjective(String title){
		super(title);
	}


}
