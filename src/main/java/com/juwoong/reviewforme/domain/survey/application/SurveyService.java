package com.juwoong.reviewforme.domain.survey.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
