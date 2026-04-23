package com.example.quiz.service;

import com.example.quiz.entity.QuizQuestion;
import com.example.quiz.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository repository;

    public List<QuizQuestion> getAllQuestions() {
        return repository.findAll();
    }

    public QuizQuestion getQuestionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public QuizQuestion saveQuestion(QuizQuestion question) {
        return repository.save(question);
    }

    public QuizQuestion updateQuestion(Long id, QuizQuestion questionDetails) {
        QuizQuestion question = getQuestionById(id);
        if (question != null) {
            question.setContent(questionDetails.getContent());
            question.setTimeLimit(questionDetails.getTimeLimit());
            question.setOptions(questionDetails.getOptions());
            question.setQuiz(questionDetails.getQuiz());
            return repository.save(question);
        }
        return null;
    }

    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}
