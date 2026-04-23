package com.example.quiz.service;

import com.example.quiz.entity.GameSession;
import com.example.quiz.entity.GameStatus;
import com.example.quiz.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameSessionService {

    @Autowired
    private GameSessionRepository repository;

    public List<GameSession> getAllSessions() {
        return repository.findAll();
    }

    public GameSession getSessionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public GameSession createSession(GameSession session) {
        session.setStartTime(LocalDateTime.now());
        session.setStatus(GameStatus.WAITING);
        session.setGamePin(generateGamePin());
        return repository.save(session);
    }

    private String generateGamePin() {
        return String.valueOf((int) ((Math.random() * (999999 - 100000)) + 100000));
    }

    public GameSession updateStatus(Long id, GameStatus status) {
        GameSession session = getSessionById(id);
        if (session != null) {
            session.setStatus(status);
            return repository.save(session);
        }
        return null;
    }

    public GameSession updateSession(Long id, GameSession sessionDetails) {
        GameSession session = getSessionById(id);
        if (session != null) {
            session.setStartTime(sessionDetails.getStartTime());
            session.setStatus(sessionDetails.getStatus());
            session.setGamePin(sessionDetails.getGamePin());
            session.setQuiz(sessionDetails.getQuiz());
            return repository.save(session);
        }
        return null;
    }

    public GameSession getSessionByPin(String pin) {
        return repository.findByGamePin(pin).orElse(null);
    }

    public void deleteSession(Long id) {
        repository.deleteById(id);
    }
}
