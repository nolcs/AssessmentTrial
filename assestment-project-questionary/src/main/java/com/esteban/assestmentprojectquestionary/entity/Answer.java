package com.esteban.assestmentprojectquestionary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String answer;

	@ManyToOne(fetch = FetchType.LAZY) //
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY) //
	@JoinColumn(name = "question_id")
	private Question question;

	public Answer() {

	}

	public Answer(Integer id, String answer, User user, Question question) {
		super();
		this.id = id;
		this.answer = answer;
		this.user = user;
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", user=" + user + ", question=" + question + "]";
	}

}
