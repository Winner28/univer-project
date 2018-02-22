package com.leti.project.services;

import com.leti.project.entities.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    private static final Long userID = 1L;
    private static final String userFirstName = "VLad";
    private static final String userLastName = "Dracula";
    private static final String userMail = "@mail.ru";
    private static final String userPasswordHash = "1234";

    @Test
    public void testThatWeCanGetExpectedPersonByID() {
        final UserEntity userEntity = usersService.getUserById(userID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getTestUserEntity());
    }

    private UserEntity getTestUserEntity() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setId(userID);
        userEntity.setFirstName(userFirstName);
        userEntity.setLastName(userLastName);
        userEntity.setEmail(userMail);
        userEntity.setPasswordHash(userPasswordHash);
        return userEntity;
    }
}