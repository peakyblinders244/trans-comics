package com.transcomics.transcomics.repositories.users.impl;

import com.transcomics.transcomics.entities.UserAccount;
import com.transcomics.transcomics.repositories.users.UserAccountRepositoryCustom;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 16:10
 */
@RequiredArgsConstructor
public class UserAccountRepositoryCustomImpl implements UserAccountRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public UserAccount findWithUserLoginDataByUserId(String userId) {
        EntityGraph<UserAccount> entityGraph = entityManager.createEntityGraph(UserAccount.class);
        entityGraph.addAttributeNodes("userLoginData");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserAccount> criteriaQuery = criteriaBuilder.createQuery(UserAccount.class);
        criteriaQuery.where(criteriaBuilder.equal(criteriaQuery.from(UserAccount.class).get("userId"), userId));
        TypedQuery<UserAccount> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("jakarta.persistence.fetchgraph", entityGraph);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
