package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.item.Item;

public record QuestionResponse(
	Long id,
	String title,
	String description,
	List<ItemResponse> itemResponses
) {
	public QuestionResponse(Question question) {
		this(
			question.getId(),
			question.getTitle(),
			question.getDescription(),
			change(question.getItems())
		);
	}

	public static List<ItemResponse> change(List<Item> items) {
		List<ItemResponse> itemResponses = items.stream().map(item -> new ItemResponse(item)).toList();

		return itemResponses;
	}
}
