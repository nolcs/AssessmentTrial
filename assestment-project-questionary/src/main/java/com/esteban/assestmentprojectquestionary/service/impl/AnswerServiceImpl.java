package com.esteban.assestmentprojectquestionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esteban.assestmentprojectquestionary.entity.Answer;
import com.esteban.assestmentprojectquestionary.repository.AnswerRepository;
import com.esteban.assestmentprojectquestionary.service.AnswerService;

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
		System.out.println(answer.toString());
		return answerRepository.save(answer);

	}

	@Override
	public Answer getAnswerById(int id) {
		return answerRepository.findById(id).orElse(null);
	}

	/*
	 * @Override public List<Answer> getAnswersByUser(User user) { List<Answer>
	 * answers = answerRepository.findByUser(user); return answers; }
	 * 
	 * @Override public List<Answer> getAnswerByQuestion(Question question) {
	 * 
	 * List<Answer> answers = answerRepository.findByQuestion(question); return
	 * answers; }
	 */

}