package med.voll.api.controllers;

import lombok.RequiredArgsConstructor;
import med.voll.api.services.ConsultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consults")
@RequiredArgsConstructor
public class ConsultController {

    public final ConsultService consultService;
}
