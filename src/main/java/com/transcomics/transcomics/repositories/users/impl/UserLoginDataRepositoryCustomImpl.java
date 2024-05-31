package com.transcomics.transcomics.repositories.users.impl;

import com.transcomics.transcomics.entities.UserLoginData;
import com.transcomics.transcomics.repositories.users.UserLoginDataRepositoryCustom;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.jpa.internal.HintsCollector;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.HashMap;
import java.util.Map;

/**
 * Le-Hong-Quan
 * Date: 26/05/2024
 * Time: 12:50
 */
@RequiredArgsConstructor
public class UserLoginDataRepositoryCustomImpl implements UserLoginDataRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public UserLoginData findWithUserAccountByLoginName(String loginName) {
        EntityGraph<UserLoginData> entityGraph = entityManager.createEntityGraph(UserLoginData.class);
        entityGraph.addAttributeNodes("userAccount");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserLoginData> criteriaQuery = criteriaBuilder.createQuery(UserLoginData.class);
        Root<UserLoginData> root = criteriaQuery.from(UserLoginData.class);
        criteriaQuery.where(criteriaBuilder.or(criteriaBuilder.equal(root.get("loginName"), loginName),
                criteriaBuilder.equal(root.get("emailAddress"), loginName)));

        TypedQuery<UserLoginData> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("jakarta.persistence.fetchgraph", entityGraph);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
