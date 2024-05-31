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
 * Time: 16:24
 */
@Getter
@Setter
@Entity(name = "t_hashing_algorithms")
@AllArgsConstructor
@NoArgsConstructor
public class HashingAlgorithms {
    @Id
    @Column(name = "hash_algorithm_id")
    private String hashAlgorithmId;
    @Column(name = "hash_algorithm_name")
    private String hashAlgorithmName;
}
