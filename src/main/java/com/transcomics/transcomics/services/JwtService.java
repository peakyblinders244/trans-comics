package com.transcomics.transcomics.services;

import com.transcomics.transcomics.model.UserDetailModel;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Le-Hong-Quan
 * Date: 25/05/2024
 * Time: 17:47
 */
public interface JwtService {
    String extractUserId(String token);

    String generateToken(UserDetailModel userDetailModel);

    String generateRefreshToken(UserDetailModel userDetailModel);

    boolean isTokenValid(String token, UserDetails userDetails);
}
