package com.quiz.Scheduler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.quiz.Model.quiz;
import com.quiz.Model.quizStatus;
import com.quiz.Repo.quizRepo;

import jakarta.transaction.Transactional;

@Component
public class quizScheduler {
	private quizStatus qstatus;
	
	private  quizRepo qrepo;

	public void QuizScheduler(quizRepo quizRepository) {
		this.qrepo = quizRepository;
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	@Transactional
	public void updateQuizStatuses() {
		LocalDateTime now = LocalDateTime.now();

		List<quiz> activeQuizs = qrepo.findAll()
				.stream()
				.filter(q -> q.getStartDate().isBefore(now) && q.getEndDate().isAfter(now))
				.collect(Collectors.toList());

		List<quiz> inactiveQuizs= qrepo.findAll()
				.stream()
				.filter(q -> q.getStartDate().isAfter(now))
				.collect(Collectors.toList());

		List<quiz> finishedQuizzes = qrepo.findAll()
				.stream()
				.filter(q -> q.getEndDate().isBefore(now))
				.collect(Collectors.toList());

		if (!activeQuizs.isEmpty()) {
			activeQuizs.forEach(q -> q.setStatus(qstatus.ACTIVE));
			qrepo.saveAll(activeQuizs);
			qrepo.flush();
		}

		if (!finishedQuizzes.isEmpty()) {
			finishedQuizzes.forEach(q -> q.setStatus(qstatus.FINISHED));
			qrepo.saveAll(finishedQuizzes);
			qrepo.flush(); 
		}

		if (!inactiveQuizs.isEmpty()) {
			inactiveQuizs.forEach(q -> q.setStatus(qstatus.FINISHED));
			qrepo.saveAll(inactiveQuizs);
			qrepo.flush(); 
		}

	}

}
