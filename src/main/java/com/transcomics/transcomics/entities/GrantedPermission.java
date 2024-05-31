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
 * Time: 17:49
 */
@Getter
@Setter
@Entity(name = "t_granted_permission")
@AllArgsConstructor
@NoArgsConstructor
public class GrantedPermission {
    @Id
    @Column(name = "granted_permission_id")
    private String grantedPermissionId;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "permission_id")
    private String permissionId;
}
