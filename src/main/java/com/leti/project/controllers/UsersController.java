package com.leti.project.controllers;

import com.leti.project.common.Methods;
import com.leti.project.common.Paths;
import com.leti.project.entities.UserEntity;
import com.leti.project.requests.users.CreateUserRequestArguments;
import com.leti.project.requests.users.UpdateUserRequestArguments;
import com.leti.project.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Paths.USERS)
@CrossOrigin(origins = "http://localhost:8000")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UsersController {

    private UsersService usersService;

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

    @PutMapping
    @PreAuthorize("permitAll()")
    public UserEntity update(@PathVariable final Long id,
                             @RequestBody final UpdateUserRequestArguments arguments) {
        arguments.setID(id);
        return usersService.update(arguments);
    }

}
