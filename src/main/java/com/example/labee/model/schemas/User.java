package com.example.labee.model.schemas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String login;
    private String firstName;
    private String lastName;
    private String hashedPassword;
}
