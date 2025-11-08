CREATE TABLE patient (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    public_place VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    number VARCHAR(20),
    complement VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL
);