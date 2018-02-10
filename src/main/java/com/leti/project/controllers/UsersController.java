package com.leti.project.controllers;

import com.leti.project.common.Methods;
import com.leti.project.common.Paths;
import com.leti.project.entities.UserEntity;
import com.leti.project.requests.users.CreateUserRequestArguments;
import com.leti.project.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Paths.USERS)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private final UsersService usersService;

    @PreAuthorize("permitAll()")
    @GetMapping(Methods.ID_PATTERN)
    public UserEntity get(@PathVariable final Long id) {
        return usersService.getUserById(id);
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public void create(@RequestBody final CreateUserRequestArguments arguments) {
        usersService.create(arguments);
    }

    @GetMapping
    @PreAuthorize("permitAll()")
    public String home() {
        return "Hello!";
    }
}
