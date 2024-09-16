package com.meenuslearning.QuizApp.Controller;

import com.meenuslearning.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    }}

