package org.example.bvito.service.users.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 *  Deals with user's password hashing
 *  @author Aleksey
 */
public class PasswordManager {

    private PasswordManager() {}

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean check(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
