package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import med.voll.api.entities.User;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
            .withIssuer("API Voll Med")
            .withSubject(user.getLogin())
            .withClaim("id", user.getId())
            .withExpiresAt(dateExpiration())
            .sign(algorithm);
            

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token.");
        }
    }

    public String validateToken(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("API Voll Med").build()
            .verify(tokenJWT)
            .getSubject();
           
        } catch (Exception e) {
            throw new RuntimeException("Token JWT inválido ou inspirado");
        }
    }

    private Instant dateExpiration() {
     return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    
}
