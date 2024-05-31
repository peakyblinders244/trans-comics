package com.transcomics.transcomics.config.audit;

import com.transcomics.transcomics.model.UserDetailModel;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * Le-Hong-Quan
 * Date: 30/05/2024
 * Time: 11:16
 */
public class ApplicationAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            return Optional.empty();
        }

        UserDetailModel userPrincipal = (UserDetailModel) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getUserId());
    }
}

