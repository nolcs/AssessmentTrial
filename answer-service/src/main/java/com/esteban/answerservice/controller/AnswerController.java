package com.esteban.answerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.answerservice.entity.Answer;
import com.esteban.answerservice.service.impl.AnswerServiceImpl;

@RestController
@RequestMapping("/answers")
public class AnswerController {

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
