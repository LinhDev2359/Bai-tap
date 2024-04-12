package org.aibles.user_profile.filter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.service.AuthTokenService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

  private final AuthTokenService authTokenService;
  private final UserProfileService userProfileService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    final String accessToken = request.getHeader("Authorization");
    if (Objects.isNull(accessToken)) {
      filterChain.doFilter(request, response);
      return;
    }

    if (!accessToken.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    var jwtToken = accessToken.substring(7);
    String userId;
    try {
      userId = authTokenService.getSubjectFromAccessToken(jwtToken);
    } catch (Exception ex) {
      ex.printStackTrace();
      filterChain.doFilter(request, response);
      return ;
    }

    if(Objects.nonNull(userId) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
      var user = userProfileService.findById(userId);
      if(authTokenService.validateAccessToken(jwtToken, userId)) {
        var usernamePasswordAuthToken =
            new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getId(), null);
        usernamePasswordAuthToken.setDetails(user);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
