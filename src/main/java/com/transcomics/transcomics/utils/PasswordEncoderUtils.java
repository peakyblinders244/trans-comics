package com.transcomics.transcomics.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 13:16
 */
public class PasswordEncoderUtils {
    public static final Integer SALT = 5;
    public static final String BCrypt = "BCrypt";
    private static final PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(SALT);

    public static PasswordEncoder getPasswordEncoder(String type) {
        switch (type) {
            case BCrypt:
                return bCryptPasswordEncoder;
            default:
                return bCryptPasswordEncoder;
        }
    }
}
