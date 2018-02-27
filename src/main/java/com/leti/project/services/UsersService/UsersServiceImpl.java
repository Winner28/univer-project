package com.leti.project.services.UsersService;

import com.leti.project.dao.daos.UserDao;
import com.leti.project.entities.UserEntity;
import com.leti.project.exceptions.ProceedEntityException;
import com.leti.project.requests.users.CreateUserRequestArguments;
import com.leti.project.requests.users.UpdateUserRequestArguments;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersServiceImpl implements UsersService {

    private UserDao userDao;


    public UserEntity getUserById(final Long id) {
        return userDao.getUserByID(id);
    }

    @Override
    public void create(final CreateUserRequestArguments arguments) {
        final UserEntity userEntity = new UserEntity()
                .setFirstName(arguments.getFistName())
                .setLastName(arguments.getLastName())
                .setPasswordHash(arguments.getPasswordHash())
                .setEmail(arguments.getEmail());
        if (userDao.create(userEntity) == null) {
         throw new ProceedEntityException("Failed when we tryed to create new User");
        }

    }

}
