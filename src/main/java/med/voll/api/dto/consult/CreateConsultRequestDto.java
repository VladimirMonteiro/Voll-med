package med.voll.api.dto.consult;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.enums.Specialty;

import java.time.LocalDateTime;

public record CreateConsultRequestDto(
        Long doctorId,
        @NotNull Long PatientId,
        @NotNull @Future LocalDateTime date,
        Specialty specialty) {
}
