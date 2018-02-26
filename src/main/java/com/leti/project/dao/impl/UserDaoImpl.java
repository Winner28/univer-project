package com.leti.project.dao.impl;

import com.leti.project.dao.AbstractJpaDao;
import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
public class UserDaoImpl extends AbstractJpaDao implements UserDao {

    @Override
    public UserEntity getUserByID(final Long ID) {
        return mapEntityManager(entityManager -> entityManager.createQuery(
                "select u from UserEntity u where u.id = :id",
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
    public void addUser(UserEntity userEntity) {
        withEntityManager(entityManager -> {
            entityManager.merge(userEntity);
        });
    }

}
