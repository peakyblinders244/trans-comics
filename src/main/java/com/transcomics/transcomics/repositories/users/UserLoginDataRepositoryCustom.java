package com.transcomics.transcomics.repositories.users;

import com.transcomics.transcomics.entities.UserLoginData;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 12:49
 */
public interface UserLoginDataRepositoryCustom {
    UserLoginData findWithUserAccountByLoginName(String loginName);
}
