package med.voll.api.controllers;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.Patient.CreatePatientRequestDto;
import med.voll.api.dto.Patient.ListDataPatient;
import med.voll.api.dto.Patient.UpdatePatientRequestDto;
import med.voll.api.entities.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping
    public void create (@RequestBody CreatePatientRequestDto dto) {
        patientRepository.save(new Patient(dto));
    }

    @GetMapping
    public Page<ListDataPatient> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return patientRepository.findAll(pageable).map(ListDataPatient::new);
    }

    @PutMapping
    public void update(@RequestBody UpdatePatientRequestDto dto) {
        var patient = patientRepository.getReferenceById(dto.id());
        patient.update(dto);
    }
}
