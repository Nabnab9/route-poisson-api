package fr.perchandcobs.routepoissonapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Document
public class Session {

    @Id
    private String id;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public String getId() {
        return id;
    }

    public Session setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Session setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Session setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Session setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }
}
