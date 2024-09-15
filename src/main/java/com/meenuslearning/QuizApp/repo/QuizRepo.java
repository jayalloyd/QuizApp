package com.meenuslearning.QuizApp.repo;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.meenuslearning.QuizApp.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String Category);//as category is a part of the table no need of customized query
}
