package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.Patient.CreatePatientRequestDto;

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
}
