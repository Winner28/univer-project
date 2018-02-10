package com.leti.project.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserEntity {
    private Long id;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
}
