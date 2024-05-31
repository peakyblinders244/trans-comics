package com.transcomics.transcomics.model.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 14:12
 */
@Getter
@Setter
public class RegisterUserReq {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String emailAddress;
    private String password;
}
