package com.leti.project.dao.impl;

import com.leti.project.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:test-context.xml")
class UserDaoImplTest {

    @Autowired
    private UserEntity userEntity;

    private static final Long ID = 1L;
    private static final String email = "@mail.ru";
    private static final String firstName = "Vlad";
    private static final String lastName = "Dracula";
    private static final String passwordHash = "1234";

    private UserEntity getUser() {
        return new UserEntity()
                .setId(ID)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPasswordHash(passwordHash);
    }

    @Test
    void getUserByID() {
        /*assertNotNull(userDaoImpl);
        final UserEntity userEntity = userDaoImpl.getUserByID(ID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getUser());*/

        System.out.println(userEntity.getFirstName());
    }

}