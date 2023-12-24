package com.juwoong.reviewforme.domain.survey.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juwoong.reviewforme.domain.survey.domain.Answer;
import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.Survey;
import com.juwoong.reviewforme.domain.survey.domain.SurveyResult;
import com.juwoong.reviewforme.domain.survey.domain.repository.SurveyRepository;

@Service
@Transactional(readOnly = true)
public class SurveyService {

	private final SurveyRepository surveyRepository;

	public SurveyService(SurveyRepository surveyRepository) {
		this.surveyRepository = surveyRepository;
	}

	@Transactional
	public Survey createSurvey(Survey survey) {
		Survey createdSurvey = surveyRepository.save(survey);

		return createdSurvey;
	}

	public Survey getSurvey(Long surveyId) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());

		return survey;
	}

	@Transactional
	public Question createQuestion(Long surveyId, Integer questionOrder, Question question) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());
		survey.makeQuestion(questionOrder, question);
		Survey saveSurvey = surveyRepository.save(survey);

		Question createdQuestion = saveSurvey.getQuestions().get(questionOrder);

		return createdQuestion;
	}

	@Transactional
	public SurveyResult receiveSurveyResult(Long surveyId, SurveyResult surveyResult) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());
		survey.receiveSurveyResult(surveyResult);
		Survey saveSurvey = surveyRepository.save(survey);

		SurveyResult lastSurveyResult = saveSurvey.getLastSurveyResult();

		return lastSurveyResult;
	}

	public List<SurveyResult> getSurveyResultsByReviewer(Long surveyId, Integer index, Integer size) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());
		List<SurveyResult> surveyResults = survey.getSurveyResults(index, size);

		return surveyResults;
	}

	public List<SurveyResult.ByField> getSurveyResultByField(Long surveyId, Long fieldId) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());
		List<SurveyResult.ByField> surveyResultByFields = survey.getSurveyResultByFields(fieldId);

		return surveyResultByFields;
	}

	@Transactional
	public SurveyResult receiveAnswer(Long surveyId, Long surveyResultId, Answer answer) {
		Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException());
		SurveyResult surveyResult = survey.getSurveyResult(surveyResultId);
		surveyResult.addAnswer(answer);

		Survey savedSurvey = surveyRepository.save(survey);
		SurveyResult savedSurveyResult = savedSurvey.getSurveyResult(surveyResultId);

		return savedSurveyResult;
	}
}
