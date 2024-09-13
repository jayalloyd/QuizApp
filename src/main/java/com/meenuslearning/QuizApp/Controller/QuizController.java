package com.meenuslearning.QuizApp.Controller;

import com.meenuslearning.QuizApp.model.Question;

import com.meenuslearning.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuizController {
    @Autowired
    QuizService service;


    @PostMapping("/create")
    public ResponseEntity<List<Question>> createQuestion(@RequestBody Question question) {
        List<Question> questions = service.createQuestion(question);

        // Return the questions list along with the HTTP status code
        return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestion(){

        return  service.getAllQuestion();
    }

}
