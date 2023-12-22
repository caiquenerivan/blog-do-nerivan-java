CREATE TABLE posts(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    titulo TEXT NOT NULL,
    sub_titulo TEXT NOT NULL,
    capa TEXT,
    texto TEXT NOT NULL,
    post_categoria TEXT NOT NULL,
    users_id TEXT NOT NULL,
    dataAtualizacao TEXT NOT NULL,
    horaAtualizacao TEXT NOT NULL,
    likes INTEGER,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_users FOREIGN KEY(users_id) REFERENCES users(id)
);
CREATE TABLE comentarios(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    users_id TEXT NOT NULL,
    texto TEXT NOT NULL,
    posts_id TEXT NOT NULL,
    likes INTEGER,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_users FOREIGN KEY(users_id) REFERENCES users(id),
    CONSTRAINT fk_posts FOREIGN KEY(posts_id) REFERENCES posts(id)
);

