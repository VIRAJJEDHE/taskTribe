package com.tasktribe.config;

import java.net.Authenticator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {    

    
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
            .csrf(csrf -> csrf.disable()) // please enable later with proper configuration
            .authorizeHttpRequests(
                request->request
                    .requestMatchers("register-user","login").permitAll()
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails viraj
    //         = User.withUsername("Viraj")
    //             .password("{noop}password")
    //             .roles("ADMIN")
    //             .build();
    //     UserDetails raj
    //     = User.withUsername("Raj")
    //         .password("{noop}rajpassword")
    //         .roles("USER")
    //         .build();
    //     return new InMemoryUserDetailsManager(viraj,raj);
    // }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

}
