package com.leti.project.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.function.Function;

@AllArgsConstructor(onConstructor = @__(@Autowired))
public abstract class AbstractJpaDao {

    protected EntityManagerFactory emf;

    protected <T> T  mapEntityManager(Function<EntityManager, T> entityManagerMapper) {
        final EntityManager entityManager = emf.createEntityManager();
        return entityManagerMapper.apply(entityManager);
    }

}
