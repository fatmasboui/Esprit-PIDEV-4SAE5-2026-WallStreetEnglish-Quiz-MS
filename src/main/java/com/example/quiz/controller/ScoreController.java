package com.example.quiz.controller;

import com.example.quiz.entity.Score;
import com.example.quiz.repository.ScoreRepository;
import com.example.quiz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
@CrossOrigin(origins ="http://localhost:4200")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @GetMapping
    public List<Score> getAll() {
        return service.getAllScores();
    }

    @GetMapping("/{id}")
    public Score getById(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @PostMapping
    public Score create(@RequestBody Score score) {
        return service.saveScore(score);
    }

    @PutMapping("/{id}")
    public Score update(@PathVariable Long id, @RequestBody Score score) {
        return service.updateScore(id, score);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteScore(id);
    }

    @GetMapping("/session/{sessionId}")
    public List<Score> getBySessionId(@PathVariable Long sessionId) {
        return service.getScoresBySessionId(sessionId);
    }
}
