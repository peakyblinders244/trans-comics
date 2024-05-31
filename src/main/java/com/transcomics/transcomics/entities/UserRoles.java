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
 * Date: 11/05/2024
 * Time: 17:52
 */
@Getter
@Setter
@Entity(name = "t_user_roles")
@AllArgsConstructor
@NoArgsConstructor
public class UserRoles {
    @Id
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "description")
    private String description;
}
