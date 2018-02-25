package com.leti.project.dao.impl;

import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:test-context.xml")
public class UserDaoImplTest {

    @Autowired
    UserDaoImpl userDao;

    private static final Long ID = 1L;
    private static final String email = "@mail.ru";
    private static final String firstName = "Vlad";
    private static final String lastName = "Dracula";
    private static final String passwordHash = "1234";

    @Test
    public void testThanWeCanGetExpectedUserByID() {
        /*final UserEntity userEntity = userDao.getUserByID(ID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getUser());*/
        userDao.sayHi();
    }


    private UserEntity getUser() {
        return new UserEntity()
                .setId(ID)
                .setEmail(email)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPasswordHash(passwordHash);
    }

}

