CREATE TABLE tareas(
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) UNIQUE not NULL,
    descripcion TEXT,
);