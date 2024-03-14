package nogari.global.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nogari.global.error.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <pre>
 *     토큰 생성과 유효성 검증을 담당
 * </pre>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final UserDetailsService userDetailsService;
    @Value("${nogari.jwt.secretKey}")
    private String secretKey;
    @Value("${nogari.jwt.signingKey}")
    private String signingKey;
    @Value("${nogari.jwt.token-valid-period}")
    private long tokenValidPeriod;

    public boolean isValidToken(String token) throws Exception {
        return getClaims(token).getExpiration().after(new Date());
    }

    public String createToken(Authentication authentication) {
        Claims claims = Jwts.claims();
        claims.put("id", authentication.getName());
        long now = new Date().getTime();
        Date expiryDate = new Date(now + tokenValidPeriod);

        return Jwts.builder().setSubject(authentication.getName()).setClaims(claims).setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }

    public Authentication getAuthentication(String token) throws Exception {
        if(!isValidToken(token)) throw new JwtException(ErrorCode.NOT_VALID_TOKEN.getMessage());

        Claims claims = getClaims(token);
        String memberId = claims.get("id").toString();
        UserDetails userDetails = userDetailsService.loadUserByUsername(memberId);

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public Claims getClaims(String token) throws Exception {
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
    }

}
