package org.example.bvito.service;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.UserAdsSchema;
import org.example.bvito.schemas.UsersSchema;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> getAllUsers();

    Optional<Users> getUserById(int u_id);

    UserAdsSchema getUserAds(int u_id);

    Users addUser(UsersSchema usersSchema);

    Users updateUser(int u_id, UsersSchema usersSchema);

    void deleteUserById(int u_id);
}
