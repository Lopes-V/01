package com11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests)-> requests
                .requestMatchers("/produto","/pedido","/pessoas","/home").hasRole("USUARIO")
                .requestMatchers("/produto/**","/pedido/**","/pessoas/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/autenticar")
                        .defaultSuccessUrl("/home",true)
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/sair")
                                .logoutSuccessUrl("/login?logout=true")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                        );
        return http.build();
    }
}