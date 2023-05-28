package com.quiz.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.Model.quiz;
@Repository
public interface quizRepo extends JpaRepository<quiz,Integer>{
	
	@Query("SELECT q FROM quiz q WHERE q.status=ACTIVE")
	List<quiz> findAllActiveQuizzes();

	Optional<quiz> findById(Integer id);


}
