package com.leti.project.requests.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequestArguments {
    private String email;
    private String passwordHash;
    private String fistName;
    private String lastName;
}
