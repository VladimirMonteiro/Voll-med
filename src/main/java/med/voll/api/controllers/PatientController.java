package med.voll.api.controllers;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.Patient.CreatePatientRequestDto;
import med.voll.api.entities.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping
    public void create (@RequestBody CreatePatientRequestDto dto) {
        patientRepository.save(new Patient(dto));
    }
}
