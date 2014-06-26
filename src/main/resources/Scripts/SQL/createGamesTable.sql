CREATE TABLE IF NOT EXISTS games(
    id        char(20) CONSTRAINT PRIMARY KEY,
    name       varchar(200) NOT NULL,
    single_player         boolean NOT NULL,
    multi_player    NOT NULL,
    coop        NOT NULL,
    coop_local        NOT NULL
);