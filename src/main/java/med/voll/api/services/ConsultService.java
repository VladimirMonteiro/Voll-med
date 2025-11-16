package med.voll.api.services;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.consult.CreateConsultRequestDto;
import med.voll.api.entities.Consult;
import med.voll.api.entities.Doctor;
import med.voll.api.entities.enums.Specialty;
import med.voll.api.repositories.ConsultRepository;
import med.voll.api.repositories.DoctorRepository;
import med.voll.api.repositories.PatientRepository;
import med.voll.api.services.exceptions.EntityValidationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultService {

    public final ConsultRepository consultRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public void createConsult(CreateConsultRequestDto dto) {
        if (!patientRepository.existsById(dto.PatientId())) {
            throw new EntityValidationException("Id do paciente informado não existe.");
        }

        if (dto.doctorId() != null && !doctorRepository.existsById(dto.doctorId())) {
            throw new EntityValidationException("Id do médico informado não existe.");

        }

        var doctor = chooseDoctor(dto);
        var patient = patientRepository.findById(dto.PatientId()).get();
        var consult = new Consult(null, doctor, patient, dto.date());
        consultRepository.save(consult);
    }

    private Doctor chooseDoctor (CreateConsultRequestDto dto) {
        if (dto.doctorId() != null) {
            return doctorRepository.getReferenceById(dto.doctorId());
        }

        if (dto.specialty() == null) {
            throw  new EntityValidationException("Especialidade é obrigatório quando o médico não for escolhido.");
        }

        return doctorRepository.chooseRandomDoctorAvailable(dto.specialty(), dto.date());
    }
}
