package com.leti.project.dao.impl;

import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserDaoImpl /*implements UserDao*/ {

    private EntityManagerFactory entityManager;

    /*@Override
    public UserEntity getUserByID(final Long ID) {
        return entityManager.createQuery(
                "select u from UserEntity u where u.id like :id",
                UserEntity.class)
                .setParameter("id", ID)
                .getSingleResult();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return entityManager.createQuery(
                "select u from UserEntity u", UserEntity.class)
                .getResultList();
    }*/

}
