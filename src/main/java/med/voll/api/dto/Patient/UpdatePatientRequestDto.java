package med.voll.api.dto.Patient;

import med.voll.api.dto.address.DataAddress;

public record UpdatePatientRequestDto(Long id, String name, String email, String phone, DataAddress address) {
}
