CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    crm VARCHAR(6) NOT NULL UNIQUE,
    specialty VARCHAR(50) NOT NULL CHECK (
        specialty IN ('ORTOPEDIA', 'CARDIOLOGIA', 'GINECOLOGIA', 'DERMATOLOGIA')
    ),
    public_place VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    number VARCHAR(20),
    complement VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL
);
