package com.example.labee.model.core;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashPassword {
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashed).verified;
    }

}
