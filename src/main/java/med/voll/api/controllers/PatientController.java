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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void create (@RequestBody CreatePatientRequestDto dto) {
        patientRepository.save(new Patient(dto));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public Page<ListDataPatient> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return patientRepository.findAll(pageable).map(ListDataPatient::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody UpdatePatientRequestDto dto) {
        var patient = patientRepository.getReferenceById(dto.id());
        patient.update(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
