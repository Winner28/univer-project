package com.leti.project.dao;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractJpaDao {

    @Autowired
    @Setter
    private EntityManagerFactory emf;

    protected <T> T mapEntityManager(Function<EntityManager, T> entityManagerMapper) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManagerMapper.apply(entityManager);
    }

    protected <T> T mapEntityManagerInTransaction(Function<EntityManager, T> entityManagerMapper) {
        return mapEntityManager(entityManager -> {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            T result = entityManagerMapper.apply(entityManager);
            entityTransaction.commit();
            return result;
        });
    }

    protected void withEntityManager(Consumer<EntityManager> entityManagerConsumer) {
        EntityManager entityManager = emf.createEntityManager();
        entityManagerConsumer.accept(entityManager);
    }

    protected void withEntityManagerInTransaction(Consumer<EntityManager> entityManagerConsumer) {
        withEntityManager(entityManager -> {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManagerConsumer.accept(entityManager);
            entityTransaction.commit();
        });
    }
}