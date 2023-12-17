package com.juwoong.reviewforme.domain.survey;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class SingleChoice extends Question{


	protected SingleChoice() {
	}

	public SingleChoice(String title){
		super(title);
	}

}
