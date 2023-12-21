CREATE TABLE users(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    nickname TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    user_type TEXT NOT NULL,
    about TEXT,
    linkedin TEXT,
    twitter TEXT,
    instagram TEXT,
    active BOOLEAN NOT NULL
);