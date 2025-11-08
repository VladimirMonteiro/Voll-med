package med.voll.api.dto.Patient;

import med.voll.api.entities.Address;
import med.voll.api.entities.Patient;

public record ListDataPatient(
        Long id,
        String name,
        String email,
        String phone,
        Address dataAddress) {

    public ListDataPatient (Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getAddress());
    }
}
