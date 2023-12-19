package com.juwoong.reviewforme.domain.survey.domain;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@ElementCollection
	@CollectionTable(name = "options", joinColumns = @JoinColumn(name = "item_id"))
	private List<Option> options;

	@ElementCollection
	@CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "item_id"))
	private List<Answer> answers;

	public void makeOptions(List<Option> options) {
		this.options = options;
	}

	public void makeAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

}
