package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;
import com.juwoong.reviewforme.domain.survey.domain.item.Item;

public record ItemResponse(
	Long id,
	String title,
	List<Option> options
) {
	public ItemResponse(Item item) {
		this(
			item.getId(),
			item.getTitle(),
			item.getOptions()
		);
	}
}
