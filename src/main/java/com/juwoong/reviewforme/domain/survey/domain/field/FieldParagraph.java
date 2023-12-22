package com.juwoong.reviewforme.domain.survey.domain.field;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "paragraphs")
public class FieldParagraph extends Field implements Subjective {

	protected FieldParagraph() {
	}

	public FieldParagraph(Long id, String title, List<Option> options) {
		this.id = id;
		this.title = title;
		this.options = options;
	}
}
