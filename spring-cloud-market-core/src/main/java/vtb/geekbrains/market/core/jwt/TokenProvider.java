package vtb.geekbrains.market.core.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TokenProvider {
    private String secret = "c29rb2xvdg==";

    public String getToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .claim("ROLE", "ROLE_USER")
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
