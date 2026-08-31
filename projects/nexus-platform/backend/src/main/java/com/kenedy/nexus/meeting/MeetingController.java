package com.kenedy.nexus.meeting;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meeting create(@Valid @RequestBody CreateMeetingRequest request) {
        return meetingService.schedule(
            request.title(),
            request.room(),
            request.department(),
            request.startsAt(),
            request.endsAt()
        );
    }

    public record CreateMeetingRequest(
        @NotBlank String title,
        @NotBlank String room,
        @NotBlank String department,
        @NotNull Instant startsAt,
        @NotNull Instant endsAt
    ) {}
}
