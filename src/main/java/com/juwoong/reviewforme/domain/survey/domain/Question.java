package com.juwoong.reviewforme.domain.survey.domain;

import java.util.List;

import com.juwoong.reviewforme.global.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "question")
	private List<Item> items;
}
