package com.juwoong.reviewforme.domain.survey.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "survey_results")
public class SurveyResult {

	@Getter
	public static class ByField {
		private Long fieldId;
		private String reviewerName;
		private String content;

		public ByField(Long fieldId, String reviewerName, String content) {
			this.fieldId = fieldId;
			this.reviewerName = reviewerName;
			this.content = content;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "survey_result_id")
	Long id;

	@Column(name = "reviewer_name")
	String reviewerName;

	@ElementCollection
	@CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "survey_result_id"))
	public List<Answer> answers = new ArrayList<>();

	protected SurveyResult() {
	}

	public SurveyResult(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	public ByField getSurveyResultByField(Long fieldId) {
		ByField surveyResultByField = answers.stream()
			.filter(answer -> answer.getFieldId() == fieldId)
			.findFirst()
			.map(answer -> new ByField(answer.getFieldId(), reviewerName, answer.getContent()))
			.orElseThrow(() -> new RuntimeException());

		return surveyResultByField;
	}
}
