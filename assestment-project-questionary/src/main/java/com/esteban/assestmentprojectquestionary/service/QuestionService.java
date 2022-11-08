package com.esteban.assestmentprojectquestionary.service;

import java.util.List;

import com.esteban.assestmentprojectquestionary.entity.Question;


public interface QuestionService {

	List<Question> findAllQuestions();

	Question createQuestion(Question question);

}
