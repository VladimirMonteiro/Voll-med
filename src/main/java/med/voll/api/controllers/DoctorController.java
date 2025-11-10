package med.voll.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.doctor.CreateDoctorRequestDto;
import med.voll.api.dto.doctor.DoctorDto;
import med.voll.api.dto.doctor.ListDataDoctor;
import med.voll.api.dto.doctor.UpdateDoctorRequestDto;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.print.Doc;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorDto> create (@RequestBody @Valid CreateDoctorRequestDto dto, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(dto);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDto(doctor));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<ListDataDoctor>> findAll (@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var page = doctorRepository.findAllActiveTrue(pageable).map(ListDataDoctor::new);
        return ResponseEntity.ok().body(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDto> update (UpdateDoctorRequestDto dto) {
        var doctor = doctorRepository.getReferenceById(dto.id());
        doctor.update(dto);
        return ResponseEntity.ok().body(new DoctorDto(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete (@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<DoctorDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new DoctorDto(doctorRepository.getReferenceById(id)));
    }
}
