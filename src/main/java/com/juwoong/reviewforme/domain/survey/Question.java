package com.juwoong.reviewforme.domain.survey;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "questions")
public abstract class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	Long id;

	@Column(name = "contents")
	String contents;

	@ElementCollection
	@CollectionTable(name = "options", joinColumns = @JoinColumn(name = "QUESTION_ID"))
	@Column(name = "OPTIONS")
	private List<Option> options;

	@Embedded
	private Reply reply;

	public Question() {
	}

	public Question(String contents) {
		this.contents = contents;
	}

	public void makeOptions(List<Option> options) {
		this.options = options;
	}
}
