package com.meenuslearning.QuizApp.Controller;

import com.meenuslearning.QuizApp.model.QuestionWrapper;
import com.meenuslearning.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService service;
    @PostMapping("/create")
    public ResponseEntity <String>createQuiz(@RequestParam String category,
                                             @RequestParam int numQ, @RequestParam String title)
    {

        return service.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
         return service.getQuizQuestion(id);}
}

