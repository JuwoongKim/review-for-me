package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;
import com.juwoong.reviewforme.domain.survey.domain.field.Field;

public record FieldResponse(
	Long id,
	String title,
	List<Option> options
) {
	public FieldResponse(Field field) {
		this(
			field.getId(),
			field.getTitle(),
			field.getOptions()
		);
	}
}
