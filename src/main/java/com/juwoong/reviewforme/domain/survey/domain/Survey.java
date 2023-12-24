package com.juwoong.reviewforme.domain.survey.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juwoong.reviewforme.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "survey_id")
	private Map<Integer, Question> questions;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "survey_id")
	private List<SurveyResult> surveyResults;

	protected Survey() {
	}

	public Survey(String title, String description) {
		this.title = title;
		this.description = description;
		this.questions = new HashMap<>();
		this.surveyResults = new ArrayList<>();
	}

	public void makeQuestion(Integer order, Question question) {
		questions.put(order, question);
	}

	public void receiveSurveyResult(SurveyResult surveyResult) {
		surveyResults.add(surveyResult);
	}

	public SurveyResult getLastSurveyResult() {
		int lastIndex = surveyResults.size() - 1;

		return surveyResults.get(lastIndex);
	}

	public SurveyResult getSurveyResult(Long surveyResultId) {
		SurveyResult selectedSurveyResult = surveyResults.stream()
			.filter(surveyResult -> surveyResult.getId() == surveyResultId)
			.findFirst()
			.orElseThrow(() -> new EntityNotFoundException());

		return selectedSurveyResult;
	}

	public List<SurveyResult> getSurveyResults(Integer index, Integer size) {
		Integer endIndex = (index + size <= surveyResults.size()) ? index + size : surveyResults.size();

		if (index == endIndex) {
			return new ArrayList<>();
		}

		List<SurveyResult> subSurveyResults = surveyResults.subList(index, endIndex);

		return subSurveyResults;
	}

	public List<SurveyResult.ByField> getSurveyResultByFields(Long fieldId) {
		List<SurveyResult.ByField> surveyResultByFields = surveyResults.stream()
			.map(surveyResult -> surveyResult.getSurveyResultByField(fieldId))
			.toList();

		return surveyResultByFields;
	}
}
