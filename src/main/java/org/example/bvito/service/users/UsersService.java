package org.example.bvito.service.users;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.service.users.exceptions.InvalidCredentials;

public interface UsersService {

    SecureUserSchema getUserById(int u_id);

    SecureUserSchema getUserByCredentials(UserAuthenticateSchema userAuthenticateSchema) throws InvalidCredentials;

    UserAdsSchema getUserAds(int u_id);

    void addUser(UserSchema userSchema);

    Users updateUser(int u_id, UserSchema userSchema);

    void deleteUserById(int u_id);
}
