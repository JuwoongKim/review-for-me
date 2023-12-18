package com.juwoong.reviewforme.domain.survey.domain;

import java.util.List;

import com.juwoong.reviewforme.global.entity.BaseEntity;

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
@Table(name = "questions")
public class Question extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	@ElementCollection
	@CollectionTable(name = "options", joinColumns = @JoinColumn(name = "question_id"))
	private List<Option> options;

	@ElementCollection
	@CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "question_id"))
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
