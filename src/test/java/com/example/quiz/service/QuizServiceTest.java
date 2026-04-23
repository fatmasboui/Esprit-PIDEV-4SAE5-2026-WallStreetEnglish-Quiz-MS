package com.example.quiz.service;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class QuizServiceTest {

    @Mock
    private QuizRepository repository;

    @InjectMocks
    private QuizService quizService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetQuizById() {
        Quiz quiz = new Quiz();
        quiz.setId(1L);
        quiz.setTitle("Java Basics");

        when(repository.findById(1L)).thenReturn(Optional.of(quiz));

        Quiz result = quizService.getQuizById(1L);

        assertNotNull(result);
        assertEquals("Java Basics", result.getTitle());
    }

    @Test
    void testSaveQuiz() {
        Quiz quiz = new Quiz();
        quiz.setTitle("New Quiz");

        when(repository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz result = quizService.saveQuiz(quiz);

        assertNotNull(result);
        assertEquals("New Quiz", result.getTitle());
    }
}
