package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.item.Item;

public record CreateQuestionRequest(
	Long questionId,
	Integer questionOrder,
	String questionTitle,
	String questionDescription,
	List<CreateItemRequest> questionItems
) {
	public Question toEntity() {
		List<Item> items = questionItems.stream().map(request -> request.toEntity()).toList();

		return new Question(questionId, questionTitle, questionDescription, items);
	}
}
