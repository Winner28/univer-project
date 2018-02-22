package com.leti.project.services;

import com.leti.project.dao.UsersMapper;
import com.leti.project.entities.UserEntity;
import com.leti.project.exceptions.ProceedEntityException;
import com.leti.project.requests.users.CreateUserRequestArguments;
import com.leti.project.requests.users.UpdateUserRequestArguments;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {

    private final UsersMapper usersMapper;

    public UserEntity getUserById(final Long id) {
        return usersMapper.getById(id);
    }

    public void create(final CreateUserRequestArguments arguments) {
        val userEntity = new UserEntity()
                .setFirstName(arguments.getFistName())
                .setLastName(arguments.getLastName())
                .setEmail(arguments.getEmail())
                .setPasswordHash(arguments.getPasswordHash());
        if (usersMapper.create(userEntity) < 0) {
            throw new ProceedEntityException("Failed to create user");
        }
    }

    public UserEntity update(final UpdateUserRequestArguments arguments) {
        val userEntity = getUserById(arguments.getID());
        if (arguments.getFirstName() != null) {
            userEntity.setFirstName(arguments.getFirstName());
        }
        if (arguments.getLastName() != null) {
            userEntity.setLastName(arguments.getLastName());
        }
        if (arguments.getEmail() != null) {
            userEntity.setEmail(arguments.getEmail());
        }
        if (arguments.getPasswordHash() != null) {
            userEntity.setPasswordHash(arguments.getPasswordHash());
        }
        if (!usersMapper.updateByID(userEntity)) {
            throw new ProceedEntityException("Failed to update user");
        }
        return userEntity;
    }
}
