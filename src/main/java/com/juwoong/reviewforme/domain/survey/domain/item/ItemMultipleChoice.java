package com.juwoong.reviewforme.domain.survey.domain.item;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "multiple_choices")
public class ItemMultipleChoice extends Item implements Selective {

	protected ItemMultipleChoice() {
	}

	public ItemMultipleChoice(Long id, String title, List<Option> options) {
		this.id = id;
		this.title = title;
		this.options = options;
	}
}
