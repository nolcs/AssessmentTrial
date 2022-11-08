package com.esteban.assestmentprojectquestionary.service;

import java.util.List;

import com.esteban.assestmentprojectquestionary.entity.Answer;


public interface AnswerService {

	List<Answer> getAllAnswers();

	Answer createAnswer(Answer answer);

	Answer getAnswerById(int id);
	
}
