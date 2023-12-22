package com.juwoong.reviewforme.domain.survey.domain.field;

import java.util.ArrayList;
import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.Option;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "fields")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Field {

	public enum FieldType {

		SHORT_ANSWER() {
			@Override
			public Field create(Long id, String title, List<Option> options) {
				return new FieldShortAnswer(id, title, options);
			}
		}, PARAGRAPH() {
			@Override
			public Field create(Long id, String title, List<Option> options) {
				return new FieldParagraph(id, title, options);
			}
		}, CHECKBOX() {
			@Override
			public Field create(Long id, String title, List<Option> options) {
				return new FieldCheckBox(id, title, options);
			}
		}, DROPDOWN() {
			@Override
			public Field create(Long id, String title, List<Option> options) {
				return new FieldDropDown(id, title, options);
			}
		}, MULTIPLE_CHOICE() {
			@Override
			public Field create(Long id, String title, List<Option> options) {
				return new FieldMultipleChoice(id, title, options);
			}
		};

		public abstract Field create(Long id, String title, List<Option> options);

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "field_id")
	public Long id;

	@Column(name = "title")
	public String title;

	@ElementCollection
	@CollectionTable(name = "options", joinColumns = @JoinColumn(name = "field_id"))
	public List<Option> options = new ArrayList<>();
}
