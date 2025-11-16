package med.voll.api.validations.consult;

import med.voll.api.dto.consult.CreateConsultRequestDto;
import med.voll.api.services.exceptions.EntityValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

public class HoursAdvanceNoticeValidation implements CreateConsultValidator {

    public void validate(CreateConsultRequestDto data) {
        var consultDate = data.date();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, consultDate).toMinutes();

        if (differenceInMinutes < 30) {
            throw new EntityValidationException("Consulta deve ser agendada com 30 minutos de antecedência");
        }
    }
}
