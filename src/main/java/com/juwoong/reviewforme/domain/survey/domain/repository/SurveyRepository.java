package com.juwoong.reviewforme.domain.survey.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juwoong.reviewforme.domain.survey.domain.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
