package com.example.labee.model.core.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
    private static final String FIXED_SALT = "$2a$12$abcdefghijklmnopqrstuv";

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, FIXED_SALT);
    }

    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }

}
