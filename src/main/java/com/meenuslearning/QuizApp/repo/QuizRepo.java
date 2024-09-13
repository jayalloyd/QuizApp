package com.meenuslearning.QuizApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.meenuslearning.QuizApp.model.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Question,Integer> {
}
