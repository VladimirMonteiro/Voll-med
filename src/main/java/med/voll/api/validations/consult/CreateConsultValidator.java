package med.voll.api.validations.consult;

import med.voll.api.dto.consult.CreateConsultRequestDto;

public interface CreateConsultValidator {

    void validate(CreateConsultRequestDto data);
}
