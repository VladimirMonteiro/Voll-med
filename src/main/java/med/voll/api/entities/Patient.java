package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.Patient.CreatePatientRequestDto;
import med.voll.api.dto.Patient.UpdatePatientRequestDto;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String email;
    private String phone;

    @Embedded
    private Address address;

    public Patient (CreatePatientRequestDto dto) {
        this.name = dto.name();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.phone = dto.phone();
        this.address = new Address(dto.address());
    }

    public void update (UpdatePatientRequestDto dto) {
        if (dto.name() != null) this.name = dto.name();
        if (dto.email() != null) this.email = dto.email();
        if (dto.phone() != null) this.phone = dto.phone();
        if (dto.address() != null) this.address.update(dto.address());
    }
}
