package com.example.quiz.service;

import com.example.quiz.entity.Score;
import com.example.quiz.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public List<Score> getAllScores() {
        return repository.findAll();
    }

    public Score getScoreById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Score saveScore(Score score) {
        return repository.save(score);
    }

    public Score updateScore(Long id, Score scoreDetails) {
        Score score = getScoreById(id);
        if (score != null) {
            score.setPoints(scoreDetails.getPoints());
            score.setUserId(scoreDetails.getUserId());
            score.setSession(scoreDetails.getSession());
            return repository.save(score);
        }
        return null;
    }

    public void deleteScore(Long id) {
        repository.deleteById(id);
    }

    public List<Score> getScoresBySessionId(Long sessionId) {
        return repository.findBySessionId(sessionId);
    }
}
