package com.example.bootstickverwaltung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Wichtig: Annotation importieren
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity  // <-- NEU: aktiviert Web Security explizit
@Configuration
public class SecurityConfig {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Erlaube statische Ressourcen oder /login.html
                        .requestMatchers("/login.html").permitAll()
                        .requestMatchers("/api/usb/login").permitAll()
                        // Rest muss evtl. authentifiziert sein
                        .anyRequest().authenticated()
                )
                // Falls du KEIN default FormLogin willst:
                .formLogin(form -> form.disable())
                .logout(logout -> logout.logoutUrl("/api/usb/logout").permitAll());

        return http.build();
    }

}
