package com.juwoong.reviewforme.domain.survey.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juwoong.reviewforme.domain.survey.domain.Survey;
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

}
