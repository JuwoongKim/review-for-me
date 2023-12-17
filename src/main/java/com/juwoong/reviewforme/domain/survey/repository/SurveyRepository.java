package com.juwoong.reviewforme.domain.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juwoong.reviewforme.domain.survey.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
