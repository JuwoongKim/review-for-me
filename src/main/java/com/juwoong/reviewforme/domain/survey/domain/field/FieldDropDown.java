package com.juwoong.reviewforme.domain.survey.domain.field;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "drop_downs")
public class FieldDropDown extends Field implements Selective {

	protected FieldDropDown() {
	}

	public FieldDropDown(Long id, String title, List<Option> options) {
		this.id = id;
		this.title = title;
		this.options = options;
	}
}
