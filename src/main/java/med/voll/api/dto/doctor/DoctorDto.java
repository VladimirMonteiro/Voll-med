package med.voll.api.dto.doctor;

import med.voll.api.entities.Address;
import med.voll.api.entities.Doctor;
import med.voll.api.entities.enums.Specialty;

public record DoctorDto(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Specialty specialty,
        Address address) {

    public DoctorDto (Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
