package org.aibles.user_profile.configuration;


import lombok.RequiredArgsConstructor;
import org.aibles.user_profile.error_handle.AuthenticationErrorHandle;
import org.aibles.user_profile.filter.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {

  private final AuthTokenFilter tokenAuthenticationFilter;
  private final AuthenticationErrorHandle authenticationErrorHandle;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/api/v1/account/**","/api/v1/user-profiles/**", "/api/v1/posts/**", "/api/v1/images/**").permitAll()
            .requestMatchers("/api/v1/user-profiles/{id}", "/api/v1/posts/**", "/api/v1/images/**").hasRole("CUSTOMER")
            .anyRequest().authenticated()
        )
        .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling().authenticationEntryPoint(authenticationErrorHandle)
        .and()
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .build();
  }
}
