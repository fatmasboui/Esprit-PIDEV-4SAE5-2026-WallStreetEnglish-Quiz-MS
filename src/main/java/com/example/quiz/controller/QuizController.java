package com.example.quiz.controller;

import com.example.quiz.entity.Quiz;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins ="http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService service;

    @GetMapping
    public List<Quiz> getAll() {
        return service.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable Long id) {
        return service.getQuizById(id);
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return service.saveQuiz(quiz);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return service.updateQuiz(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteQuiz(id);
    }
}
