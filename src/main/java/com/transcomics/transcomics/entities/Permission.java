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
 * Time: 17:45
 */

@Getter
@Setter
@Entity(name = "t_permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @Column(name = "permission_id")
    private String permissionId;
    @Column(name = "path")
    private String path;
    @Column(name = "method")
    private String method;
    @Column(name = "description")
    private String description;
}
