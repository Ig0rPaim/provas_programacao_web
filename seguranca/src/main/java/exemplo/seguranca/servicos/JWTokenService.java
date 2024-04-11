package exemplo.seguranca.servicos;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;

import exemplo.seguranca.entidades.Usuario;

@Service
public class JWTokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	
	public String gerarToken(Usuario usuario) {
		try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("PWEB API")
                .withSubject(usuario.getLogin())
                .withExpiresAt(dataExpiracao())
                .withClaim("id", usuario.getId())
                .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }        
    }
		
	private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
	
	public String getSubject(String tokenJWT) {
        try {
                var algoritmo = Algorithm.HMAC256(secret);
                return JWT.require(algoritmo)
                                .withIssuer("PWEB API")
                                .build()
                                .verify(tokenJWT)
                                .getSubject();
        } catch (JWTVerificationException exception) {
                throw new RuntimeException("Token JWT inválido ou expirado!");
        }
}

public Claim getId(String tokenJWT) {
    try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                            .withIssuer("PWEB API")
                            .build()
                            .verify(tokenJWT)
                            .getClaim("id");
    } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
    }
}

}