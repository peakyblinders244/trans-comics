package com.transcomics.transcomics.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Le-Hong-Quan
 * Date: 24/05/2024
 * Time: 16:26
 */

@Getter
@Setter
@Entity(name = "t_user_login_data_external")
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDataExternal {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "external_provider_id")
    private String externalProviderId;
    @Column(name = "external_provider_token")
    private String externalProviderToken;
}
