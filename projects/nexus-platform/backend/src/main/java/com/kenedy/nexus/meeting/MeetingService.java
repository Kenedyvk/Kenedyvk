package com.kenedy.nexus.meeting;

import java.time.Instant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class MeetingService {
    private final MeetingRepository meetings;

    public MeetingService(MeetingRepository meetings) {
        this.meetings = meetings;
    }

    @Transactional
    public Meeting schedule(String title, String room, String department, Instant startsAt, Instant endsAt) {
        if (!endsAt.isAfter(startsAt)) {
            throw new ResponseStatusException(BAD_REQUEST, "Meeting end must be after start");
        }
        if (!meetings.findConflicts(room, startsAt, endsAt).isEmpty()) {
            throw new ResponseStatusException(CONFLICT, "Room already booked for the requested period");
        }
        return meetings.save(new Meeting(title, room, department, startsAt, endsAt));
    }
}
