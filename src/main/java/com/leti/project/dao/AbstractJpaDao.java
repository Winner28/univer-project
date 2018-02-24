package com.leti.project.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public abstract class AbstractJpaDao {

    protected EntityManagerFactory emf;

    protected <T> T  mapEntityManager(Function<EntityManager, T> entityManagerMapper) {
        final EntityManager entityManager = emf.createEntityManager();
        return entityManagerMapper.apply(entityManager);
    }

    protected <T> T mapEntityManagerTransactional(Function<EntityManager, T> entityManagerMapper) {
        return mapEntityManager(entityManager -> {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            T result = entityManagerMapper.apply(entityManager);
            entityTransaction.commit();
            return result;
        });
    }

    protected void withEntityManager(Consumer<EntityManager> entityManagerSupplier) {
        final EntityManager entityManager = emf.createEntityManager();
        entityManagerSupplier.accept(entityManager);
    }

    protected void withEntityManagerTransactional(Consumer<EntityManager> entityManagerTransactional) {
        withEntityManager(entityManager -> {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManagerTransactional.accept(entityManager);
            transaction.commit();
        });
    }


}
