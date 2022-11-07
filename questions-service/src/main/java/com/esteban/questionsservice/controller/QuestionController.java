package com.esteban.questionsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteban.questionsservice.entity.Question;
import com.esteban.questionsservice.service.QuestionServiceImpl;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionServiceImpl;

	@GetMapping("/listquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {

		List<Question> questions = questionServiceImpl.findAllQuestions();
		if (questions.isEmpty()) {

			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(questions);
	}

	@PostMapping
	public ResponseEntity<Question> createQuestion(@RequestBody Question question) {

		Question newQuestion = questionServiceImpl.createQuestion(question);

		return ResponseEntity.ok(question);

	}

}
