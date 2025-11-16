package med.voll.api.repositories;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.Doctor;
import med.voll.api.entities.enums.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByActiveTrue (Pageable pageable);

    @Query("""
            SELECT d FROM Doctor d
            WHERE
            m.active = true
            AND
            m.specialty = :specialty
            m.id not in(
                SELECT c.doctor.id FROM Consult c
                WHERE
                c.date = :date
            )
            ORDER BY rand()
            LIMIT 1
            """)
    Doctor chooseRandomDoctorAvailable (Specialty specialty, @NotNull @Future LocalDateTime date);
}
