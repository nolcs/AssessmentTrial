package com.esteban.assestmentprojectquestionary.service;

import java.util.List;

import com.esteban.assestmentprojectquestionary.entity.Answer;
import com.esteban.assestmentprojectquestionary.entity.Question;
import com.esteban.assestmentprojectquestionary.entity.User;


public interface AnswerService {

	List<Answer> getAllAnswers();

	Answer createAnswer(Answer answer);

	Answer getAnswerById(int id);
	
	//List<Answer> getAnswersByUser(User user);
	
	//List<Answer> getAnswerByQuestion(Question question);

}
