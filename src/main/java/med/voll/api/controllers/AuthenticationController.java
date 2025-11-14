package med.voll.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.auth.DataTokenJWT;
import med.voll.api.dto.auth.LoginRequestDto;
import med.voll.api.entities.User;
import med.voll.api.infra.security.TokenService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginRequestDto dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokentJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok().body(new DataTokenJWT(tokentJWT));
    }
    
}
