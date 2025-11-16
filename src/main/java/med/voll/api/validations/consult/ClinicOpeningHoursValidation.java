package med.voll.api.validations.consult;

import med.voll.api.dto.consult.CreateConsultRequestDto;
import med.voll.api.services.exceptions.EntityValidationException;

import java.time.DayOfWeek;

public class ClinicOpeningHoursValidation implements CreateConsultValidator {

    public void validate(CreateConsultRequestDto data) {
        var consultDate = data.date();

        var sunday = consultDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var beforeClosingClinic = consultDate.getHour() < 7;
        var afterClosingClinic = consultDate.getHour() > 18;

        if (sunday || beforeClosingClinic || afterClosingClinic) {
            throw  new EntityValidationException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
