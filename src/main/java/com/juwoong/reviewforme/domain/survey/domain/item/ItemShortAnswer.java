package com.juwoong.reviewforme.domain.survey.domain.item;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "short_answer")
public class ItemShortAnswer extends Item implements Subjective {

	protected ItemShortAnswer() {
	}

	public ItemShortAnswer(String title, List<Option> options) {
		this.title = title;
		this.options = options;
	}
}
