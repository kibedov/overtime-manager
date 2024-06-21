CREATE TABLE production_calendar
(
    id   BIGSERIAL PRIMARY KEY,
    year SMALLINT NOT NULL
);

CREATE TABLE month_info
(
    id                     BIGSERIAL PRIMARY KEY,
    name                   VARCHAR(9) NOT NULL,
    working_days           SMALLINT   NOT NULL,
    not_working_days       SMALLINT   NOT NULL,
    short_days             SMALLINT   NOT NULL,
    working_hours          SMALLINT   NOT NULL,
    production_calendar_id BIGSERIAL  NOT NULL
);

