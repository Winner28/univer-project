package com.leti.project.services.UsersService;

import com.leti.project.entities.UserEntity;
import com.leti.project.requests.users.CreateUserRequestArguments;

public interface UsersService {
    UserEntity getUserById(final Long id);
    void create(final CreateUserRequestArguments arguments);
}
