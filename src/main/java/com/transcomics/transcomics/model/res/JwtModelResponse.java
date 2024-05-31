package com.transcomics.transcomics.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 14:46
 */
@Getter
@Setter
@AllArgsConstructor
public class JwtModelResponse {
    private String token;
    private String refreshToken;
}
