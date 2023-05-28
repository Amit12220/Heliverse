package com.quiz.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Exception.quizException;
import com.quiz.Model.quiz;
import com.quiz.Model.quizAnswerDTO;
import com.quiz.Repo.quizRepo;
@Service
public class quizServiceImpl implements quizService{
	
	@Autowired
	private quizRepo qrepo;

	@Override
	public quiz RegisterQuizQues(quiz quiz_1) throws quizException {
		// TODO Auto-generated method stub
		
		if(quiz_1!=null)
		{
			qrepo.save(quiz_1);
			return quiz_1;
		}
		else
		{
			throw new quizException("Invalid Data Entry");
		}
	}

	@Override
	public List<quiz> getActiveQuiz() throws quizException {
		// TODO Auto-generated method stub
		List<quiz> li=qrepo.findAllActiveQuizzes();
		if(li!=null)
		{
			return li;
		}
		else
		{
			throw new quizException("No Active Quiz is Available");
		}
	}

	@Override
	public List<quiz> getAllQuizzes() throws quizException {
		// TODO Auto-generated method stub
		List<quiz> li=qrepo.findAll();
		if(li!=null)
		{
			return li;
		}
		else
		{
			throw new quizException("No Quiz is Available");
		}
	}

	@Override
	public quizAnswerDTO getQuizResult(Integer id) throws quizException {
		// TODO Auto-generated method stub
		Optional<quiz> quiz_1=qrepo.findById(id);

		if(quiz_1.isPresent()) {
			quiz q=quiz_1.get();
			LocalDateTime ldt=LocalDateTime.now();
			long duration=Duration.between(q.getEndDate(),ldt).toMinutes();
			if(duration>5){
				quiz answer = quiz_1.get();
				quizAnswerDTO q1=new quizAnswerDTO();
				
				q1.setQuestion(answer.getQuestion());
				q1.setOptions(answer.getOptions());
				q1.setAnswer(answer.getOptions().get(answer.getRightAnswerIndex()));
				return  q1;
			}else{
				throw  new quizException("Try after 5 Minute when the quiz will end");
			}
		}else {
			throw new quizException("Invalid Id");
		}

	}

}
