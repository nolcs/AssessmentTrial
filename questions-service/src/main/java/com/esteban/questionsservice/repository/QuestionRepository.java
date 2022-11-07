package com.esteban.questionsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esteban.questionsservice.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	
}
