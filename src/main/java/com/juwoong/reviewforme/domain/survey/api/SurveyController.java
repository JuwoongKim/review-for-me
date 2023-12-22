package com.juwoong.reviewforme.domain.survey.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juwoong.reviewforme.domain.survey.api.dto.CreateAnswerRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.CreateQuestionRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.CreateSurveyRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.CreateSurveyResultRequest;
import com.juwoong.reviewforme.domain.survey.api.dto.QuestionResponse;
import com.juwoong.reviewforme.domain.survey.api.dto.SurveyResponse;
import com.juwoong.reviewforme.domain.survey.api.dto.SurveyResultPageResponse;
import com.juwoong.reviewforme.domain.survey.api.dto.SurveyResultResponse;
import com.juwoong.reviewforme.domain.survey.application.SurveyService;
import com.juwoong.reviewforme.domain.survey.domain.Answer;
import com.juwoong.reviewforme.domain.survey.domain.Question;
import com.juwoong.reviewforme.domain.survey.domain.Survey;
import com.juwoong.reviewforme.domain.survey.domain.SurveyResult;

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

		return new ResponseEntity<>(surveyResponse, HttpStatus.OK);
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

	@PostMapping("/surveyResult")
	public ResponseEntity<SurveyResultResponse> receiveSurveyResult(
		@RequestParam("survey-id") Long surveyId,
		@RequestBody CreateSurveyResultRequest createSurveyResultRequest
	) {
		SurveyResult surveyResult = createSurveyResultRequest.toEntity();
		SurveyResult createdSurveyResult = surveyService.receiveSurveyResult(surveyId, surveyResult);

		SurveyResultResponse surveyResultResponse = new SurveyResultResponse(createdSurveyResult);

		return new ResponseEntity<>(surveyResultResponse, HttpStatus.CREATED);
	}

	@GetMapping("/surveyResult")
	public ResponseEntity<SurveyResultPageResponse> getSurveyResults(
		@RequestParam("survey-id") Long surveyId,
		@RequestParam(defaultValue = "0") Integer index,
		@RequestParam(defaultValue = "12") Integer size
	) {
		List<SurveyResult> surveyResults = surveyService.getSurveyResults(surveyId, index, size);
		boolean hasNext = surveyResults.size() == size;

		List<SurveyResultResponse> SurveyResultResponses = surveyResults.stream()
			.map(surveyResult -> new SurveyResultResponse(surveyResult))
			.toList();

		SurveyResultPageResponse surveyResultPageResponse = new SurveyResultPageResponse(
			SurveyResultResponses,
			index + size - 1,
			hasNext
		);

		return new ResponseEntity<>(surveyResultPageResponse, HttpStatus.OK);
	}

	@PostMapping("/surveyResult/answer")
	public ResponseEntity<SurveyResultResponse> receiveAnswer(
		@RequestParam("survey-id") Long surveyId,
		@RequestParam("survey-result-id") Long surveyResultId,
		@RequestBody CreateAnswerRequest createAnswerRequest
	) {
		Answer answer = createAnswerRequest.toValue();
		SurveyResult updatedSurveyResult = surveyService.receiveAnswer(surveyId, surveyResultId, answer);

		SurveyResultResponse surveyResultResponse = new SurveyResultResponse(updatedSurveyResult);

		return new ResponseEntity<>(surveyResultResponse, HttpStatus.OK);
	}
}
