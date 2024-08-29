package com.example.labee.model.core;

import com.example.labee.model.core.helpers.XMLParser;
import com.example.labee.model.schemas.User;
import com.example.labee.model.schemas.XMLUsers;

import java.io.File;

public class Auth {
    private XMLUsers users;
    private User user;

    public Auth(User user, File xmlFile) {
        this.user = user;
        users = (XMLUsers) XMLParser.deserialize(xmlFile, new XMLUsers());
    }

    public boolean logIn() {
        if (users.getByLogin(user.getLogin()) != null) {
            return users.getByLogin(user.getLogin()).getHashedPassword().equals(user.getHashedPassword());
        } else {
            return false;
        }
    }

}
