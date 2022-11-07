package com.esteban.questionsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.questionsservice.entity.Question;
import com.esteban.questionsservice.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAllQuestions() {
		List<Question> questions  = questionRepository.findAll();
		return questions;
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

}
