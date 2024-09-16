package com.meenuslearning.QuizApp.repo;

import com.meenuslearning.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {

}
