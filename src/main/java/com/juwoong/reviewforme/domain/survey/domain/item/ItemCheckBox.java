package com.juwoong.reviewforme.domain.survey.domain.item;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "check_boxs")
public class ItemCheckBox extends Item implements Selective {

	protected ItemCheckBox() {
	}

	public ItemCheckBox(String title, List<Option> options) {
		this.title = title;
		this.options = options;
	}
}
