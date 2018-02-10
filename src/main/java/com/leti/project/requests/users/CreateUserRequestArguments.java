package com.leti.project.requests.users;

import lombok.Data;
import lombok.Getter;

@Data
public class CreateUserRequestArguments {
    private String email;
    private String passwordHash;
    private String fistName;
    private String lastName;
}
