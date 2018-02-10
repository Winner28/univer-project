package com.leti.project.services;

import com.leti.project.dao.UsersMapper;
import com.leti.project.entities.UserEntity;
import com.leti.project.exceptions.CreatingEntityException;
import com.leti.project.requests.users.CreateUserRequestArguments;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersService {

    private final UsersMapper usersMapper;

    public UserEntity getUserById(final Long id) {
        return new UserEntity().setFirstName("SUKA");
    }

    public void create(CreateUserRequestArguments arguments) {
        val userEntity = new UserEntity()
                .setFirstName(arguments.getFistName())
                .setLastName(arguments.getLastName())
                .setEmail(arguments.getEmail())
                .setPasswordHash(arguments.getPasswordHash());
        if (usersMapper.create(userEntity) < 0) {
            throw new CreatingEntityException("Failed to create user");
        }
    }

}
