package med.voll.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.consult.CancelConsultRequestDto;
import med.voll.api.services.ConsultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consults")
@RequiredArgsConstructor
public class ConsultController {

    public final ConsultService consultService;

    @DeleteMapping
    public ResponseEntity<Void> cancelConsult(@RequestBody @Valid CancelConsultRequestDto dto) {
        consultService.cancelConsult(dto);
        return ResponseEntity.noContent().build();
    }
}
