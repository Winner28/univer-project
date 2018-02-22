package com.leti.project.requests.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequestArguments {
    private Long ID;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private String email;

}
