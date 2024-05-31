package com.transcomics.transcomics.repositories.users;

import com.transcomics.transcomics.entities.UserAccount;
import com.transcomics.transcomics.entities.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 13:22
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, String>, UserAccountRepositoryCustom {
}
