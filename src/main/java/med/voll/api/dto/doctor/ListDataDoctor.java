package med.voll.api.dto.doctor;

import med.voll.api.entities.Doctor;
import med.voll.api.entities.enums.Specialty;

public record ListDataDoctor(Long id, String name, String email, String crm, Specialty specialty) {

    public ListDataDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
