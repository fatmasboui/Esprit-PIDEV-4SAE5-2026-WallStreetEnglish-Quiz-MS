package com.example.quiz.controller;

import com.example.quiz.entity.QuizQuestion;
import com.example.quiz.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-questions")
@CrossOrigin(origins ="http://localhost:4200")
public class QuizQuestionController {

    @Autowired
    private QuizQuestionService service;

    @GetMapping
    public List<QuizQuestion> getAll() {
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuizQuestion getById(@PathVariable Long id) {
        return service.getQuestionById(id);
    }

    @PostMapping
    public QuizQuestion create(@RequestBody QuizQuestion question) {
        return service.saveQuestion(question);
    }

    @PutMapping("/{id}")
    public QuizQuestion update(@PathVariable Long id, @RequestBody QuizQuestion question) {
        return service.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteQuestion(id);
    }
}
