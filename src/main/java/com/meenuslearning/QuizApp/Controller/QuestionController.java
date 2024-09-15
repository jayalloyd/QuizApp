package com.meenuslearning.QuizApp.Controller;

import com.meenuslearning.QuizApp.model.Question;

import com.meenuslearning.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired

    QuestionService service;


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
    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable("category") String category){
        return service.getQuestionByCategory(category);
    }

}
