package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.entities.enums.ReasonCancellation;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private ReasonCancellation reasonCancellation;

    public void cancel(ReasonCancellation reasonCancellation) {
        this.reasonCancellation = reasonCancellation;
    }
}
