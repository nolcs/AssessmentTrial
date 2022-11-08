package com.esteban.answerservice.service;

import java.util.List;

import com.esteban.answerservice.entity.Answer;

public interface AnswerService {
	
	List<Answer> getAllAnswers();
	
	Answer createAnswer(Answer answer);
	
	Answer getAnswerById(int id);

}
