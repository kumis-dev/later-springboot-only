CREATE TABLE IF NOT EXISTS users
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name varchar(255),
    email varchar(255),
    registration_date TIMESTAMP,
    state varchar(50)
);

CREATE TABLE IF NOT EXISTS items
(
    id      bigint generated always as identity primary key,
    name    varchar(255) not null,
    user_id bigint       not null
);
