CREATE TABLE production_calendar(
    id BIGSERIAL PRIMARY KEY,
    year SMALLINT NOT NULL,
    month VARCHAR(9) NOT NULL,
    working_days SMALLINT NOT NULL,
    not_working_days SMALLINT NOT NULL,
    short_days SMALLINT NOT NULL,
    working_hours SMALLINT NOT NULL
);