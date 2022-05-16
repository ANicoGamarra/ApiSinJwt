package com.ap.PorfolioApiV8.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtProvider {
    
    //private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt-secret}")
    private String secretKey;

    @Value("${jwt-secret}")
    private String secret;

    @Value("${jwt-expiration}")
    private int expiration;

 /*    public String generarToken(Authentication authentication) {
        String username = authentication.getName();       
       
        String token = Jwts.builder().setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime() + expiration * 1000))
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();

        return token;
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }

    public String refreshToken(String token) {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Date fechaExpiracion = claims.getExpiration();
        String username = this.getNombreUsuarioFromToken(token);
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .signWith(SignatureAlgorithm.HS512, secret).compact();

    }
 */

    //token de walter
    public String getJWTToken(String username) {

        //String secretKey = "W3L0v3Arg3nt1n4";


        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("ap17380")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora de duración
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes())
                .compact();

        return "Bearer " + token;
    }

}
