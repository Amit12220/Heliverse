package com.quiz.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@Entity
public class quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String question;
	@ElementCollection
	@CollectionTable(name = "quizOptions")
	@NotNull
	@NotEmpty
	private List<String> options;
	@Column(nullable = false)
	@NotNull
	private Integer rightAnswerIndex;
	@Column(nullable = false)
	@NotNull
	private LocalDateTime startDate;
	@Column(nullable = false)
	@NotNull
	private LocalDateTime endDate;
	@Column(nullable = false)
	@NotNull
	private quizStatus  status;
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
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public Integer getRightAnswerIndex() {
		return rightAnswerIndex;
	}
	public void setRightAnswerIndex(Integer rightAnswerIndex) {
		this.rightAnswerIndex = rightAnswerIndex;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public quizStatus getStatus() {
		return status;
	}
	public void setStatus(quizStatus status) {
		this.status = status;
	}
	public quiz() {
		super();
	}
	public quiz(Integer id, @NotNull @NotEmpty String question, @NotNull @NotEmpty List<String> options,
			@NotNull Integer rightAnswerIndex, @NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate,
			@NotNull quizStatus status) {
		super();
		this.id = id;
		this.question = question;
		this.options = options;
		this.rightAnswerIndex = rightAnswerIndex;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	
	


}
