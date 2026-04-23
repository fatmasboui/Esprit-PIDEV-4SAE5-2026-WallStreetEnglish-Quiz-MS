package com.example.quiz.service;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository repository;

    public List<Quiz> getAllQuizzes() {
        return repository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Quiz saveQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public Quiz updateQuiz(Long id, Quiz quizDetails) {
        Quiz quiz = getQuizById(id);
        if (quiz != null) {
            quiz.setTitle(quizDetails.getTitle());
            quiz.setDescription(quizDetails.getDescription());
            quiz.setCreatedBy(quizDetails.getCreatedBy());
            return repository.save(quiz);
        }
        return null;
    }

    public void deleteQuiz(Long id) {
        repository.deleteById(id);
    }
}
