package com.leti.project.services;

import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import com.leti.project.services.UsersService.UsersService;
import com.leti.project.services.UsersService.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration("classpath:test-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class UsersServiceTest {

    @Autowired
    private UsersService usersServiceImpl;

    private static final Long ID = 1L;
    private static final String email = "@mail.ru";
    private static final String firstName = "Vlad";
    private static final String lastName = "Dracula";
    private static final String passwordHash = "1234";


    @Test
    void testThatWeCanGetExpectedUserByID() {
        // System.out.println(userDaoImpl.getAllUsers() + "AAAAAAAAAAAAAAAAAAAAAAAAAAA");
     /*   assertNotNull(userDaoImpl);
        final UserEntity userEntity = userDaoImpl.getUserByID(ID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getUser());*/
    }

    @Test
    void testThatWeCanAddUser() {
       /* userDaoImpl.addUser(getUser());
        final UserEntity userEntity = userDaoImpl.getUserByID(ID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getUser());*/
        usersServiceImpl.getUserById(ID);
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