package via.sep3.group11.tier2.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerator {


    public String generateToken(Authentication authentication, String role) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);


        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .claim("Role", role)
                .setAudience("SEP3BlazorWASM")
                .setIssuer("SEP3Tier2")
                .claim("name", username)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .setHeaderParam("typ", "JWT")
                .compact();

        return token;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("JWT-token was expired or incorrect.");
        }
    }
}
