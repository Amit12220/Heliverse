package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Exception.quizException;
import com.quiz.Model.quiz;
import com.quiz.Model.quizAnswerDTO;
import com.quiz.Service.quizService;

@RestController
public class quizController {
	@Autowired
	private quizService qserv;
	
	@PostMapping("/quiz/register")
	public ResponseEntity<quiz> createQuiz(@RequestBody quiz quiz_1) throws quizException {
		return new ResponseEntity<quiz>(qserv.RegisterQuizQues(quiz_1),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/quiz/active")
	public ResponseEntity<List<quiz>> getActiveQuiz() throws quizException {
		return new ResponseEntity<List<quiz>>(qserv.getActiveQuiz(),HttpStatus.OK);
	}
	@GetMapping("/quiz/{id}")
	public ResponseEntity<quizAnswerDTO> getQuizResult(@PathVariable Integer id) throws quizException {
		return new ResponseEntity<quizAnswerDTO>(qserv.getQuizResult(id),HttpStatus.OK);
	}
	@GetMapping("/quiz/all")
	public ResponseEntity<List<quiz>> getAllQuizzes() throws quizException {
		return new ResponseEntity<List<quiz>>(qserv.getAllQuizzes(),HttpStatus.OK);
	}

}
