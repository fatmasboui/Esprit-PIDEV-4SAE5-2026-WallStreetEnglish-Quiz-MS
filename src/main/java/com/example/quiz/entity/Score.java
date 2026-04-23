package com.example.quiz.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonBackReference
    private GameSession session;

    public Score() {
        // Empty constructor for JPA
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public GameSession getSession() { return session; }
    public void setSession(GameSession session) { this.session = session; }
}
