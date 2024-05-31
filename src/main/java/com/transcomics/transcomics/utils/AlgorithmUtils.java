package com.transcomics.transcomics.utils;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Le-Hong-Quan
 * Date: 25/05/2024
 * Time: 17:50
 */
public class AlgorithmUtils {
    public static SignatureAlgorithm getSignatureUsed(){
        return SignatureAlgorithm.HS256;
    }
}
