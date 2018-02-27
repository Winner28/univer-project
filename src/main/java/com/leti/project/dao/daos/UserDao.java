package com.leti.project.dao.daos;

import com.leti.project.entities.UserEntity;

import java.util.List;

public interface UserDao {
    UserEntity getUserByID(final Long ID);
    List<UserEntity> getAllUsers();
    UserEntity create(final UserEntity userEntity);
}
