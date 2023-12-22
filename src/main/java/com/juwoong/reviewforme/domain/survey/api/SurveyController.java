package com.juwoong.reviewforme.domain.survey.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reviewforme.domain.survey.api.dto.CreateQuestionRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.CreateSurveyRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.QuestionResponse;
import com.juwoong.reviewforme.domain.survey.api.dto.SurveyResponse;
import com.juwoong.reviewforme.domain.survey.application.SurveyService;
import com.juwoong.reviewforme.domain.survey.domain.Question;
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

	@GetMapping("/{survey-id}")
	public ResponseEntity<SurveyResponse> getSurvey(@PathVariable("survey-id") Long surveyId) {
		Survey survey = surveyService.getSurvey(surveyId);
		SurveyResponse surveyResponse = new SurveyResponse(survey);

		return new ResponseEntity<> (surveyResponse, HttpStatus.OK);
	}

	@PostMapping("/question")
	public ResponseEntity<QuestionResponse> createQuestion(
		@RequestParam("survey-id") Long surveyId,
		@RequestBody CreateQuestionRequest createQuestionRequest
	) {
		Question question = createQuestionRequest.toEntity();

		Question createdQuestion = surveyService.createQuestion(
			surveyId,
			createQuestionRequest.questionOrder(),
			question
		);

		QuestionResponse questionResponse = new QuestionResponse(createdQuestion);
		return new ResponseEntity<>(questionResponse, HttpStatus.CREATED);
	}

}
