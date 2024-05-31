package com.transcomics.transcomics.repositories.users;

import com.transcomics.transcomics.entities.UserAccount;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 13:22
 */
public interface UserAccountRepositoryCustom {
    UserAccount findWithUserLoginDataByUserId(String userId);
}
