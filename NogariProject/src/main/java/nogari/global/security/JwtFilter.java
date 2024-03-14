package nogari.global.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private static final String TOKEN_HEADER_PREFIX = "Bearer ";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Authorization";
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = resolveToken(request);

        Authentication authentication = null;
        try {
            authentication = jwtTokenProvider.getAuthentication(token);
        } catch (Exception e) {
            log.error("[{}.doFilterInternal]", this.getClass().getSimpleName(), e);
        }

        // TO-DO : SecurityContextHolder 대신 redis나 기타 디비를 이용할 방법은?
        // 그리고 굳이 디비를 활용했을 때 얻을 수 있는 장점은?
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 해당 경로에는 트리거되지 않도록 필터를 구성
        return request.getServletPath().equals("/login") || request.getServletPath().equals("/logout") || request.getServletPath().equals("/signup");
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER_PREFIX);
        if (StringUtils.startsWithIgnoreCase(bearerToken, TOKEN_HEADER_PREFIX)) {
            return StringUtils.replace(bearerToken, TOKEN_HEADER_PREFIX, "");
        }
        return null;
    }
}
