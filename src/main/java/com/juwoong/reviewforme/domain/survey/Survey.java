package com.juwoong.reviewforme.domain.survey;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SURVEY_ID")
	public Long id;

	@Column(name = "TITLE")
	public String title;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "SURVEY_ID")
	private Map<Integer, Question> questions;

	protected Survey(){};

	public Survey(String title){
		this.title = title;
		this.questions = new HashMap<>();
	}

	public void makeQuestion(int key, Question question){
		questions.put(key, question);

	}

	public Map<Integer, Question> getQuestions() {
		return questions;
	}
}
