package com.esteban.assestmentprojectquestionary.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

	import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String question;

	@OneToMany(mappedBy = "question")
	@JsonIgnore
	private List<Answer> answer;

	public Question() {
	}

	public Question(Integer id, String question, List<Answer> answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

}