package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.field.Field;
import com.juwoong.reviewforme.domain.survey.domain.Option;

public record CreateFieldRequest(
	Long fieldId,
	String fieldTitle,
	Field.FieldType fieldType,
	List<CreateOptionRequest> fieldOptions
) {
	public Field toEntity() {
		List<Option> options = fieldOptions.stream().map(request -> request.toValue()).toList();

		return fieldType.create(this.fieldId, this.fieldTitle, options);
	}
}
