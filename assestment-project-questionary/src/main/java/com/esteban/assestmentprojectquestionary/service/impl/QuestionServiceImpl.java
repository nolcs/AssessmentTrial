package com.esteban.assestmentprojectquestionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.assestmentprojectquestionary.entity.Question;
import com.esteban.assestmentprojectquestionary.repository.QuestionRepository;
import com.esteban.assestmentprojectquestionary.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAllQuestions() {
		List<Question> questions = questionRepository.findAll();
		return questions;
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

}
