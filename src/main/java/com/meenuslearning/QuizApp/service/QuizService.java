package com.meenuslearning.QuizApp.service;

import com.meenuslearning.QuizApp.model.Question;
import com.meenuslearning.QuizApp.model.QuestionWrapper;
import com.meenuslearning.QuizApp.model.Quiz;
import com.meenuslearning.QuizApp.model.Response;
import com.meenuslearning.QuizApp.repo.QuestionRepo;
import com.meenuslearning.QuizApp.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
    Optional<Quiz> quiz=repo.findById(id);
    List<Question>questionFromDb=quiz.get().getQuestions();
    List<QuestionWrapper>questionForUser=new ArrayList<>();
    for(Question q:questionFromDb){
        QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQues(),q.getA(),q.getB(),q.getC());
        questionForUser.add(qw);
    }
    return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
    Quiz quiz=repo.findById(id).get();
    List<Question>questions=quiz.getQuestions();
    int right=0;
    int i=0;
        for(Response res: response){
            if(res.getResponse().equals(questions.get(i).getRightAnswer()))
                i++;

        }right++;
        return
                 new ResponseEntity<>(right,HttpStatus.OK);
    }
}
