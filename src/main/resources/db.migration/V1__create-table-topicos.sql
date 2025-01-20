CREATE TABLE topico (
    id bigint not null auto_increment,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor INT,
    curso INT,
    primary key(id)

)