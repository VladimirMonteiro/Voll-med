package med.voll.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.doctor.CreateDoctorRequestDto;
import med.voll.api.dto.doctor.ListDataDoctor;
import med.voll.api.dto.doctor.UpdateDoctorRequestDto;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void create (@RequestBody @Valid CreateDoctorRequestDto dto) {
        doctorRepository.save(new Doctor(dto));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public Page<ListDataDoctor> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return doctorRepository.findAllActiveTrue(pageable).map(ListDataDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update (UpdateDoctorRequestDto dto) {
        var doctor = doctorRepository.getReferenceById(dto.id());
        doctor.update(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();

    }
}
