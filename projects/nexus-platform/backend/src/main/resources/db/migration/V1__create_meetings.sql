CREATE TABLE meetings (
    id UUID PRIMARY KEY,
    title VARCHAR(120) NOT NULL,
    room VARCHAR(80) NOT NULL,
    department VARCHAR(80) NOT NULL,
    starts_at TIMESTAMPTZ NOT NULL,
    ends_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT ck_meetings_time_range CHECK (ends_at > starts_at)
);

CREATE INDEX idx_meetings_room_time ON meetings (LOWER(room), starts_at, ends_at);
