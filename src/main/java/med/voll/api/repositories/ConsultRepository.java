package med.voll.api.repositories;

import med.voll.api.entities.Consult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultRepository extends JpaRepository<Consult, Long> {
}
