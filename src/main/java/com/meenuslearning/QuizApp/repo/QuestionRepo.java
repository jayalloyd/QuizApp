package com.meenuslearning.QuizApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.meenuslearning.QuizApp.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {


    List<Question> findByCategory(String Category);//as category is a part of the table no need of customized query
    @Query(value="SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
