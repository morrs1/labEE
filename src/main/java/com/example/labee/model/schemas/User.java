package com.example.labee.model.schemas;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class User {
    private String login;
    private String firstName;
    private String lastName;
    private String hashedPassword;
}
