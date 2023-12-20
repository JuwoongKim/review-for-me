package com.juwoong.reviewforme.domain.survey.domain.item;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "paragraphs")
public class ItemParagraph extends Item implements Subjective {

	protected ItemParagraph() {
	}

	public ItemParagraph(String title, List<Option> options) {
		this.title = title;
		this.options = options;
	}
}
