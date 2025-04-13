package com.example.barberbookingsystembackend.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Slår CSRF fra (for nu)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/h2-console/**").permitAll()  // Tillader adgang til H2 konsollen uden login
                                .anyRequest().permitAll()  // Alle andre requests kræver login
                )
                .formLogin(withDefaults())  // Tillader login for alle
                .logout(withDefaults());  // Tillader logout for alle

        // Deaktiverer frame-options for H2 konsollen, som gør det muligt at åbne konsollen i en iframe
        http.headers(headers -> headers.frameOptions().disable());

        return http.build();  // Byg og returner sikkerhedsfilteret
    }

    }