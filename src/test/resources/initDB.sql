INSERT INTO users (ID, email, firstName, lastName, passwordHash)
  VALUES (1, '@mail.ru', 'Vlad', 'Dracula', '1234');


/*
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
        */
/*assertNotNull(userDaoImpl);
        final UserEntity userEntity = userDaoImpl.getUserByID(ID);
        assertNotNull(userEntity);
        assertEquals(userEntity, getUser());*//*

        System.out.println(userEntity.getFirstName());
    }
*/
