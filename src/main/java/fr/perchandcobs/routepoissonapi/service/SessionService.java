package fr.perchandcobs.routepoissonapi.service;

import fr.perchandcobs.routepoissonapi.domain.Position;
import fr.perchandcobs.routepoissonapi.domain.Session;
import fr.perchandcobs.routepoissonapi.exception.NotFoundException;
import fr.perchandcobs.routepoissonapi.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    private final PositionService positionService;


    public SessionService(SessionRepository sessionRepository, PositionService positionService) {
        this.sessionRepository = sessionRepository;
        this.positionService = positionService;
    }

    public List<Session> findAllByEndDateIsNull() {
        return sessionRepository.findAllByEndDateIsNull();
    }

    public Session createSession() {
        return sessionRepository.save(
                new Session()
                        .setName("Ma session")
                        .setStartDate(LocalDateTime.now())
        );
    }

    public Session endSession(String sessionId) {
        LocalDateTime sessionEndDate = positionService.findLastPositionInSession(sessionId)
                .map(Position::getDateTime)
                .orElseGet(LocalDateTime::now);
        return sessionRepository.findById(sessionId)
                .map(s -> s.setEndDate(sessionEndDate))
                .map(sessionRepository::save)
                .orElseThrow(NotFoundException::new);

    }
}
