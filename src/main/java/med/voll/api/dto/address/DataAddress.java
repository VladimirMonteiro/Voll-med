package med.voll.api.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
        @NotBlank
        String publicPlace,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String uf,
        String complement,
        String number) {
}
