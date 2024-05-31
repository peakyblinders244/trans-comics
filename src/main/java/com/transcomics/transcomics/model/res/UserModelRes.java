package com.transcomics.transcomics.model.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 16:05
 */
@Getter
@Setter
public class UserModelRes {
    private String userId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String roleId;
    private String emailAddress;
    private String loginName;
}
