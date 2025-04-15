package org.example.bvito.service.users.utils;

import org.example.bvito.models.User;
import org.example.bvito.schemas.user.in.UserAuthenticateSchema;

/**
 *  Authorizes user
 *  @author Aleksey
 */
public class UserAuthentication {

    public static boolean authorize(UserAuthenticateSchema userAuthenticateSchema, User user) {
        return PasswordManager.check(userAuthenticateSchema.getPassword(), user.getPassword());
    }
}
