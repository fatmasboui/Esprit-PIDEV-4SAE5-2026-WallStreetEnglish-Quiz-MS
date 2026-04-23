package com.example.quiz.controller;

import com.example.quiz.entity.Quiz;
import com.example.quiz.service.QuizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
    controllers = QuizController.class,
    excludeAutoConfiguration = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration.class
    }
)
class QuizControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @Test
    void testGetAllQuizzes() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setId(1L);
        quiz.setTitle("General Knowledge");

        given(quizService.getAllQuizzes()).willReturn(Arrays.asList(quiz));

        mockMvc.perform(get("/quizzes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("General Knowledge"));
    }

    @Test
    void testGetAllQuizzesReturnsEmpty() throws Exception {
        given(quizService.getAllQuizzes()).willReturn(Arrays.asList());

        mockMvc.perform(get("/quizzes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
