import com.example.quiz.entity.GameSession;
import com.example.quiz.entity.GameStatus;
import com.example.quiz.service.GameSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game-sessions")
@CrossOrigin(origins ="http://localhost:4200")
@RequiredArgsConstructor
public class GameSessionController {

    private final GameSessionService service;

    @GetMapping
    public ResponseEntity<List<GameSession>> getAll() {
        return ResponseEntity.ok(service.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameSession> getById(@PathVariable Long id) {
        GameSession session = service.getSessionById(id);
        return session != null ? ResponseEntity.ok(session) : ResponseEntity.notFound().build();
    }

    @GetMapping("/pin/{pin}")
    public ResponseEntity<GameSession> getByPin(@PathVariable String pin) {
        GameSession session = service.getSessionByPin(pin);
        return session != null ? ResponseEntity.ok(session) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<GameSession> create(@RequestBody GameSession session) {
        return ResponseEntity.ok(service.createSession(session));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<GameSession> updateStatus(@PathVariable Long id, @RequestParam GameStatus status) {
        GameSession updated = service.updateStatus(id, status);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameSession> update(@PathVariable Long id, @RequestBody GameSession session) {
        GameSession updated = service.updateSession(id, session);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}

