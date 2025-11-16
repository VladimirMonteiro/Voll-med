package med.voll.api.dto.consult;

import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.enums.ReasonCancellation;

public record CancelConsultRequestDto(@NotNull Long idConsult, @NotNull ReasonCancellation reasonCancellation) {
}
