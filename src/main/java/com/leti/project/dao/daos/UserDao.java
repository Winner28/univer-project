package com.leti.project.dao.daos;

import com.leti.project.entities.UserEntity;

public interface UserDao {
    UserEntity getUserByID(final Long ID);

}
