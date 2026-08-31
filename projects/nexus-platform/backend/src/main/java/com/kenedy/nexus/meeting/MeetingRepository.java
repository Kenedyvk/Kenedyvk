package com.kenedy.nexus.meeting;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
    @Query("""
        select m from Meeting m
        where lower(m.room) = lower(:room)
          and m.startsAt < :endsAt
          and m.endsAt > :startsAt
        """)
    List<Meeting> findConflicts(@Param("room") String room,
                                @Param("startsAt") Instant startsAt,
                                @Param("endsAt") Instant endsAt);
}
