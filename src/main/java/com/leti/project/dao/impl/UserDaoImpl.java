package com.leti.project.dao.impl;

import com.leti.project.dao.AbstractJpaDao;
import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Repository
public class UserDaoImpl extends AbstractJpaDao implements UserDao {

    public UserDaoImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public UserEntity getUserByID(final Long ID) {
        return mapEntityManager(entityManager -> entityManager.createQuery(
                "select u from UserEntity u where u.id like :id",
                UserEntity.class)
                .setParameter("id", ID)
                .getSingleResult());
    }

}
