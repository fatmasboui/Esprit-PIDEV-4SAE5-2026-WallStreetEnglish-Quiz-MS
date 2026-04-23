package com.example.quiz.controller;

import com.example.quiz.entity.GameSession;
import com.example.quiz.entity.GameStatus;
import com.example.quiz.service.GameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game-sessions")
@CrossOrigin(origins ="http://localhost:4200")
public class GameSessionController {

    @Autowired
    private GameSessionService service;

    @GetMapping
    public List<GameSession> getAll() {
        return service.getAllSessions();
    }

    @GetMapping("/{id}")
    public GameSession getById(@PathVariable Long id) {
        return service.getSessionById(id);
    }

    @GetMapping("/pin/{pin}")
    public GameSession getByPin(@PathVariable String pin) {
        return service.getSessionByPin(pin);
    }

    @PostMapping
    public GameSession create(@RequestBody GameSession session) {
        return service.createSession(session);
    }

    @PatchMapping("/{id}/status")
    public GameSession updateStatus(@PathVariable Long id, @RequestParam GameStatus status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/{id}")
    public GameSession update(@PathVariable Long id, @RequestBody GameSession session) {
        return service.updateSession(id, session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSession(id);
    }
}
