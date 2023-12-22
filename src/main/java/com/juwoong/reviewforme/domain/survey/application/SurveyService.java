package com.juwoong.reviewforme.domain.survey.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.Survey;
import com.juwoong.reviewforme.domain.survey.domain.repository.ItemRepository;
import com.juwoong.reviewforme.domain.survey.domain.repository.QuestionRepository;
import com.juwoong.reviewforme.domain.survey.domain.repository.SurveyRepository;

@Service
@Transactional(readOnly = true)
public class SurveyService {

	private final SurveyRepository surveyRepository;
	private final QuestionRepository questionRepository;
	private final ItemRepository itemRepository;

	public SurveyService(SurveyRepository surveyRepository, QuestionRepository questionRepository,
		ItemRepository itemRepository) {
		this.surveyRepository = surveyRepository;
		this.questionRepository = questionRepository;
		this.itemRepository = itemRepository;
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
		question.setSurvey(survey);

		Question createdQuestion = questionRepository.save(question);

		return createdQuestion;

	}

}
