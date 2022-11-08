package com.esteban.assestmentprojectquestionary.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.assestmentprojectquestionary.entity.Answer;
import com.esteban.assestmentprojectquestionary.service.impl.AnswerServiceImpl;

@RestController
@RequestMapping("/answers")
public class AnswerController {

	private final Log LOG = LogFactory.getLog(AnswerController.class);

	@Autowired
	private AnswerServiceImpl answerServiceImpl;

	@GetMapping("/listAnswers")
	public ResponseEntity<List<Answer>> listAllAnswers() {

		List<Answer> answers = answerServiceImpl.getAllAnswers();

		if (answers.isEmpty()) {

			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(answers);
	}

	@PostMapping
	public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {

		Answer newAnswer = answerServiceImpl.createAnswer(answer);
		LOG.info(newAnswer);
		return ResponseEntity.ok(newAnswer);
	}

	@GetMapping("/{answerId}")
	public ResponseEntity<Answer> findAnswer(@PathVariable("answerId") int answerId) {

		Answer answer = answerServiceImpl.getAnswerById(answerId);
		if (answer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(answer);
	}

}
