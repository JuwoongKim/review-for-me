package com.juwoong.reviewforme.domain.survey.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reviewforme.domain.survey.api.dto.CreateSurveyRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.SurveyResponse;
import com.juwoong.reviewforme.domain.survey.application.SurveyService;
import com.juwoong.reviewforme.domain.survey.domain.Survey;

@RestController
@RequestMapping("/survey")
public class SurveyController {

	private final SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping
	public ResponseEntity<SurveyResponse> createSurvey(@RequestBody CreateSurveyRequest surveyRequest) {
		Survey survey = surveyRequest.toEntity();
		Survey createdSurvey = surveyService.createSurvey(survey);
		SurveyResponse surveyResponse = new SurveyResponse(createdSurvey);

		return new ResponseEntity<>(surveyResponse, HttpStatus.CREATED);
	}
}
