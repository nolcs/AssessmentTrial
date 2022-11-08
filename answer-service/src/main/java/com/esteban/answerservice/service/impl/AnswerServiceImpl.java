package com.esteban.answerservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.answerservice.entity.Answer;
import com.esteban.answerservice.repository.AnswerRepository;
import com.esteban.answerservice.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public List<Answer> getAllAnswers() {
		List<Answer> answers = answerRepository.findAll();
		return answers;
	}

	@Override
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public Answer getAnswerById(int id) {
		return answerRepository.findById(id).orElse(null);
	}
	
	
}
