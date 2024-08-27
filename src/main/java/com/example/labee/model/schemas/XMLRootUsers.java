package com.example.labee.model.schemas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class XMLRootUsers {
    private List<User> usersList;

    public User getByLogin() {
        return new User(null, null, null, null);
    }

}
