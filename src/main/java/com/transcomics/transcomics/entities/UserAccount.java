package com.transcomics.transcomics.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Le-Hong-Quan
 * Date: 11/05/2024
 * Time: 18:12
 */
@Getter
@Setter
@Entity(name = "t_user_account")
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "role_id")
    private String roleId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserLoginData userLoginData;
}
