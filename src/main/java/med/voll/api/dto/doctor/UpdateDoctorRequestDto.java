package med.voll.api.dto.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.address.DataAddress;

public record UpdateDoctorRequestDto(
        @NotNull
        Long id,
        String name,
        String phone,
        @Valid DataAddress address) {
}
