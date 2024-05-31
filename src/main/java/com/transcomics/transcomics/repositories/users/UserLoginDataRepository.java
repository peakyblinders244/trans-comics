package com.transcomics.transcomics.repositories.users;

import com.transcomics.transcomics.entities.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 11:44
 */
public interface UserLoginDataRepository extends JpaRepository<UserLoginData, String>, UserLoginDataRepositoryCustom {
}
