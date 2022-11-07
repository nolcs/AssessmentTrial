package com.esteban.questionsservice.service;

import java.util.List;

import com.esteban.questionsservice.entity.Question;

public interface QuestionService {
	
	List<Question> findAllQuestions();
	
	Question createQuestion(Question question);
	
}
