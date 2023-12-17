package com.juwoong.reviewforme.domain.survey.repository;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.juwoong.reviewforme.domain.survey.Option;
import com.juwoong.reviewforme.domain.survey.Question;
import com.juwoong.reviewforme.domain.survey.SingleChoice;
import com.juwoong.reviewforme.domain.survey.Subjective;
import com.juwoong.reviewforme.domain.survey.Survey;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class SurveyRepositoryTest {

	@Autowired
	private SurveyRepository surveyRepository;

	@Test
	void func(){
		List<Option> options = List.of(
			new Option("123"),
			new Option("456")
		);

		Question question = new SingleChoice("this is road");
		question.makeOptions(options);

		Survey survey = new Survey("this is survey");
		survey.makeQuestion(1, question);
		Survey survey1 = surveyRepository.save(survey);

		Map<Integer, Question> questions = survey1.getQuestions();
		System.out.println("dddddd");
		System.out.println(questions.size());

		for (Map.Entry<Integer, Question> entry : questions.entrySet()) {
			Integer key = entry.getKey();
			Question value = entry.getValue();

			System.out.println("Key: " + key + ", Value: " + value);
		}
	}

}