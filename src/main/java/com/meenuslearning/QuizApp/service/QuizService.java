package com.meenuslearning.QuizApp.service;

import com.meenuslearning.QuizApp.model.Question;
import com.meenuslearning.QuizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizService {
    @Autowired
    QuizRepo repo;
    public List<Question> getAllQuestion() {
        return repo.findAll();

    }

    public List<Question>createQuestion(Question question) {
         repo.save(question);
        return repo.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
    return repo.findByCategory(category);
    }
}
