CREATE TABLE consult (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    date TIMESTAMP NOT NULL,

    CONSTRAINT fk_consults_doctor_id
        FOREIGN KEY (doctor_id) REFERENCES doctor(id),

    CONSTRAINT fk_consults_patient_id
        FOREIGN KEY (patient_id) REFERENCES patient(id)
);
