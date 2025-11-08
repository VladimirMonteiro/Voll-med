package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.doctor.CreateDoctorRequestDto;
import med.voll.api.dto.doctor.UpdateDoctorRequestDto;
import med.voll.api.entities.enums.Specialty;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String crm;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(CreateDoctorRequestDto dto) {
        this.active = true;
        this.name = dto.name();
        this.email = dto.email();
        this.phone = dto.phone();
        this.crm = dto.crm();
        this.specialty = dto.specialty();
        this.address = new Address(dto.address());
    }

    public void update (UpdateDoctorRequestDto dto) {
        if (dto.name() != null) this.name = dto.name();
        if (dto.phone() != null) this.phone = dto.phone();
        if (dto.address() != null) this.address.update(dto.address());
    }

    public void delete () {
        this.active = false;
    }
}
