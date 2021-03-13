package fr.perchandcobs.routepoissonapi.controller;

import fr.perchandcobs.routepoissonapi.domain.Session;
import fr.perchandcobs.routepoissonapi.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SessionController {

    private final SessionService sessionService;


    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/sessions/{sessionId}/end")
    public ResponseEntity<Session> endSession(@PathVariable String sessionId) {
        return ResponseEntity.ok(sessionService.endSession(sessionId));
    }
}
