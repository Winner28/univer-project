package com.leti.project.dao.impl;

import com.leti.project.dao.AbstractJpaDao;
import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;


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

    @Override
    public List<UserEntity> getAllUsers() {
        return mapEntityManager(entityManager -> entityManager.createQuery(
                "select u from UserEntity u", UserEntity.class)
                .getResultList());
    }

    @Override
    public void sayHi() {
        System.out.println("hi i guess");
    }

}
