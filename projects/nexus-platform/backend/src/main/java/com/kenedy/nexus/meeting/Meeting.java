package com.kenedy.nexus.meeting;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 80)
    private String room;

    @Column(nullable = false, length = 80)
    private String department;

    @Column(nullable = false)
    private Instant startsAt;

    @Column(nullable = false)
    private Instant endsAt;

    protected Meeting() {}

    public Meeting(String title, String room, String department, Instant startsAt, Instant endsAt) {
        this.title = title;
        this.room = room;
        this.department = department;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getRoom() { return room; }
    public String getDepartment() { return department; }
    public Instant getStartsAt() { return startsAt; }
    public Instant getEndsAt() { return endsAt; }
}
