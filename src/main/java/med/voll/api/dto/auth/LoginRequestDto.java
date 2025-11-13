package med.voll.api.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(@NotBlank String login, @NotBlank String password) {
}
