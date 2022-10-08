package vtb.geekbrains.market.product.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret;

    public boolean validateToken(String token) {
        boolean success = false;
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            success = true;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String getRole(String token) {
        String role = "";
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        if (claims != null) {
            role = claims.get("ROLE", String.class);
        }
        return role;
    }
}