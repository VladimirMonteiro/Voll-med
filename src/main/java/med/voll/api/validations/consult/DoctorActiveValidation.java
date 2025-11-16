package med.voll.api.validations.consult;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.consult.CreateConsultRequestDto;
import med.voll.api.repositories.DoctorRepository;
import med.voll.api.services.exceptions.EntityValidationException;

@RequiredArgsConstructor
public class DoctorActiveValidation implements CreateConsultValidator{

    private final DoctorRepository doctorRepository;

    public void validate (CreateConsultRequestDto data) {

        if (data.doctorId() == null) {
            return;
        }

        var doctorActive = doctorRepository.existsByIdAndActiveTrue(data.doctorId());
        if (!doctorActive) {
            throw new EntityValidationException("A consulta não pode ser marcada com um médico excluido.");
        }
    }
}
