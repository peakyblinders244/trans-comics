package com.transcomics.transcomics.entities;

import jakarta.persistence.*;
import lombok.*;
import org.flywaydb.core.internal.parser.TokenType;

/**
 * Le-Hong-Quan
 * Date: 01/06/2024
 * Time: 15:39
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_token")
public class Token {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(unique = true, name = "token")
    public String token;

    @Column(name = "token_type")
    public String tokenType = "BEARER";

    @Column(name = "revoked")
    public boolean revoked;

    @Column(name = "expired")
    public boolean expired;

    @Column(name = "user_id")
    private String userId;

}
