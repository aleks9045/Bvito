package org.example.bvito.service.users.utils;

import org.example.bvito.models.Users;
import org.example.bvito.repository.UsersRepository;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;
import org.springframework.stereotype.Component;


public class UserAuthentication {

    public static boolean check(UserAuthenticateSchema userAuthenticateSchema, Users user) {
        return PasswordManager.check(userAuthenticateSchema.getPassword(), user.getPassword());
    }
}
