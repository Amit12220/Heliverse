package com.quiz.Exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private  String detail;

	public MyErrorDetails() {
	}

	public MyErrorDetails(LocalDateTime timestamp, String message, String detail) {
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
