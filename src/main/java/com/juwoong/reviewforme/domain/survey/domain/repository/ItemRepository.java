package com.juwoong.reviewforme.domain.survey.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juwoong.reviewforme.domain.survey.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
