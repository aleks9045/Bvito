package org.example.bvito.service;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> getAllUsers();

    Optional<Users> getUserById(int u_id);

    UserAdsSchema getUserAds(int u_id);

    Users addUser(UserSchema userSchema);

    Users updateUser(int u_id, UserSchema userSchema);

    void deleteUserById(int u_id);
}
