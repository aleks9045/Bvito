package org.example.bvito.service.users.utils;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;

/**
 *  Authorizes user
 *  @author Aleksey
 */
public class UserAuthentication {

    public static boolean authorize(UserAuthenticateSchema userAuthenticateSchema, Users user) {
        return PasswordManager.check(userAuthenticateSchema.getPassword(), user.getPassword());
    }
}
