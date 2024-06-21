CREATE TABLE overtime(
    id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    duration SMALLINT NOT NULL,
    compensation NUMERIC(19,2) NOT NULL
);