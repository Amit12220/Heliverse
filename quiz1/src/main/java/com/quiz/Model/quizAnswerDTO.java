package com.quiz.Model;

import java.util.List;

public class quizAnswerDTO {

	private String question;
	private List<String> options;
	private String answer;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public quizAnswerDTO() {
		super();
	}
	public quizAnswerDTO(String question, List<String> options, String answer) {
		super();
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	
	
}
