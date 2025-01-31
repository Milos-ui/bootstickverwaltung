package com.example.bootstickverwaltung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Wichtig: Annotation importieren
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ggf. nur zu Testzwecken
                .authorizeHttpRequests(auth -> auth
                        // Swagger-UI, API-Docs etc. erlauben:
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                        // Deine API-Endpunkte ggf. frei oder per Auth
                        .requestMatchers("/api/usb/**").permitAll()
                        // ... oder wenn du restliche Endpunkte absichern willst:
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()) // oder .formLogin(form -> form.disable())
                .logout(withDefaults());

        return http.build();
    }
}
