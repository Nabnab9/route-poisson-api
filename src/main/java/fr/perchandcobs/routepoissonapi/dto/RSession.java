package fr.perchandcobs.routepoissonapi.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

public class RSession {

    private String id;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public String getId() {
        return id;
    }

    public RSession setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RSession setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public RSession setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public RSession setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }
}
