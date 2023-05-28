package com.quiz.Service;

import java.util.List;

import com.quiz.Exception.quizException;
import com.quiz.Model.quiz;
import com.quiz.Model.quizAnswerDTO;

public interface quizService {
	
	public quiz RegisterQuizQues(quiz quiz_1) throws quizException;
	public List<quiz> getActiveQuiz() throws quizException;
	public List<quiz> getAllQuizzes() throws quizException;
	public quizAnswerDTO getQuizResult(Integer id) throws quizException;

}
