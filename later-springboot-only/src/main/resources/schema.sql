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
    url     varchar(2000) not null,
    user_id bigint       not null
);

CREATE TABLE IF NOT EXISTS item_tags
(
    item_id bigint not null references items(id) on delete cascade,
    tag     varchar(255) not null,
    primary key (item_id, tag)
);

CREATE TABLE IF NOT EXISTS item_notes
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    text varchar(2000) NOT NULL,
    item_id BIGINT NOT NULL REFERENCES items(id) ON DELETE CASCADE,
    note_date TIMESTAMP NOT NULL
);
