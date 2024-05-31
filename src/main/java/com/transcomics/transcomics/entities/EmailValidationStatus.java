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
 * Time: 16:25
 */
@Getter
@Setter
@Entity(name = "t_email_validation_status")
@AllArgsConstructor
@NoArgsConstructor
public class EmailValidationStatus {
    @Id
    @Column(name = "email_validation_status_id")
    private String emailValidationStatusId;
    @Column(name = "description")
    private String description;
}
