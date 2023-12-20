package com.juwoong.reviewforme.domain.survey.domain;

import java.util.HashMap;
import java.util.Map;

import com.juwoong.reviewforme.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "surveys")
public class Survey extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "survey_id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "survey", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private Map<Integer, Question> questions;

	protected Survey() {
	}

	public Survey(String title, String description) {
		this.title = title;
		this.description = description;
		this.questions = new HashMap<>();
	}

	public void makeQuestion(Integer order, Question question) {
		questions.put(order, question);
	}
}
