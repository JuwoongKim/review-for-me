package com.juwoong.reviewforme.domain.survey.domain.item;

import java.util.ArrayList;
import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Answer;
import com.juwoong.reviewforme.domain.survey.domain.Option;
import com.juwoong.reviewforme.domain.survey.domain.Question;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

	public enum ItemType {

		SHORT_ANSWER() {
			@Override
			public Item create(Long id, String title, List<Option> options) {
				return new ItemShortAnswer(id, title, options);
			}
		}, PARAGRAPH() {
			@Override
			public Item create(Long id, String title, List<Option> options) {
				return new ItemParagraph(id, title, options);
			}
		}, CHECKBOX() {
			@Override
			public Item create(Long id, String title, List<Option> options) {
				return new ItemCheckBox(id, title, options);
			}
		}, DROPDOWN() {
			@Override
			public Item create(Long id, String title, List<Option> options) {
				return new ItemDropDown(id, title, options);
			}
		}, MULTIPLE_CHOICE() {
			@Override
			public Item create(Long id, String title, List<Option> options) {
				return new ItemMultipleChoice(id, title, options);
			}
		};

		public abstract Item create(Long id, String title, List<Option> options);

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	public Long id;

	@Column(name = "item_title")
	public String title;

	@ElementCollection
	@CollectionTable(name = "options", joinColumns = @JoinColumn(name = "item_id"))
	public List<Option> options = new ArrayList<>();
}
