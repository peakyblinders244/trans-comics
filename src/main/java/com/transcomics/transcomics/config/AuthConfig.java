package com.transcomics.transcomics.config;

import com.transcomics.transcomics.config.audit.ApplicationAuditAware;
import com.transcomics.transcomics.services.UserService;
import com.transcomics.transcomics.utils.PasswordEncoderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Le-Hong-Quan
 * Date: 30/05/2024
 * Time: 13:15
 */
@Configuration
@RequiredArgsConstructor
public class AuthConfig {
    private final UserService userService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderUtils.getPasswordEncoder(PasswordEncoderUtils.BCrypt);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userId -> {
            UserDetails userDetails = userService.getUserDetailModelByUserId(userId);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return userDetails;
        };
    }


    @Bean
    public AuditorAware<String> auditorAware() {
        return new ApplicationAuditAware();
    }
}
