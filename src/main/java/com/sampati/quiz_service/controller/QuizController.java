package com.sampati.quiz_service.controller;


import com.sampati.quiz_service.model.QuestionWrapper;
import com.sampati.quiz_service.model.QuizDto;
import com.sampati.quiz_service.model.Response;
import com.sampati.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> SubmitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResponse(id,responses);
    }

}
