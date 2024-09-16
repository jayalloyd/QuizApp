package com.meenuslearning.QuizApp.service;

import com.meenuslearning.QuizApp.model.Question;
import com.meenuslearning.QuizApp.model.Quiz;
import com.meenuslearning.QuizApp.repo.QuestionRepo;
import com.meenuslearning.QuizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class QuizService {
    @Autowired
    QuizRepo repo;
    @Autowired
    QuestionRepo quesrepo;



    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
    List<Question> questions=quesrepo.findRandomQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
    quiz.setTitle(title);
    quiz.setQuestions(questions);
     repo.save(quiz);
    return  new ResponseEntity<>("succes", HttpStatus.CREATED);

    }
}
