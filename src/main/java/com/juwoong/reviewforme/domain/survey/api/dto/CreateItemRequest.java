package com.juwoong.reviewforme.domain.survey.api.dto;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.item.Item;
import com.juwoong.reviewforme.domain.survey.domain.Option;

public record CreateItemRequest(
	Long itemId,
	String itemTitle,
	Item.ItemType itemType,
	List<CreateOptionRequest> itemOptions
) {
	public Item toEntity() {
		List<Option> options = itemOptions.stream().map(request -> request.toValue()).toList();

		return itemType.create(this.itemId, this.itemTitle, options);
	}
}
