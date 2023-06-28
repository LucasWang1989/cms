package nz.ac.sit.cms.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 * @program: cms
 * @description: Token Generator
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-31 20:32
 **/
public class TokenGenerator {
    private static final String SECRET_KEY = "3F7935F422AF58E8E3EBC8F8B1A4C3F7935F422AF58E8E3EBC8F8B1A4C";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    public static String generateToken(String userId) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static String validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return "";
        }
    }
}
