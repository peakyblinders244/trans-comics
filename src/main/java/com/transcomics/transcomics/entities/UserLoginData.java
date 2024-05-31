package com.transcomics.transcomics.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Le-Hong-Quan
 * Date: 24/05/2024
 * Time: 16:20
 */

@Getter
@Setter
@Entity(name = "t_user_login_data")
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginData {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "password_salt")
    private Integer passwordSalt;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "hash_algorithm_id")
    private String hashAlgorithmId;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "token_generation_time")
    private Date tokenGenerationTime;
    @Column(name = "email_validation_status_id")
    private String emailValidationStatusId;
    @Column(name = "password_recovery_token")
    private String passwordRecoveryToken;
    @Column(name = "recover_token_time")
    private Date recoverTokenTime; // recover_token_time password

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;


}
