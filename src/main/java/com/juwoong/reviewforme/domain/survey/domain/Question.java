package com.juwoong.reviewforme.domain.survey.domain;

import java.util.List;

import com.juwoong.reviewforme.domain.survey.domain.field.Field;
import com.juwoong.reviewforme.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "question_id")
	private List<Field> fields;

	protected Question() {

	}

	public Question(Long id, String title, String description, List<Field> fields) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.fields = fields;
	}
}
