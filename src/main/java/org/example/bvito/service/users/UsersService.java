package org.example.bvito.service.users;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.service.users.exceptions.InvalidCredentials;
import org.example.bvito.service.users.impl.UsersServiceImpl;

/**
 *  A set of methods for business logic with {@link Users} model
 *
 *  @author Aleksey
 *
 *  @see UsersServiceImpl implementation of this interface
 */
public interface UsersService {
    /**
     * Gets user entry from database
     *
     * @param u_id user id
     * @return {@link SecureUserSchema}
     */
    SecureUserSchema getUserById(int u_id);

    /**
     * Gets user entry from database with credentials
     * <p>
     * Performs user authorization by verifying that the
     * provided credentials (login and password) match the data in the database.
     *
     * @param userAuthenticateSchema username and password
     * @return {@link SecureUserSchema}
     * @throws InvalidCredentials auth error, which occurs when wrong user's data sent
     */
    SecureUserSchema getUserByCredentials(UserAuthenticateSchema userAuthenticateSchema) throws InvalidCredentials;

    /**
     * Gets each user's ad entry from database
     * @param u_id user id
     * @return {@link UserAdsSchema}
     */
    UserAdsSchema getUserAds(int u_id);

    /**
     * Adds user entry from database with credentials
     * @param userSchema user schema {@link UserSchema}
     */
    void addUser(UserSchema userSchema);

    /**
     * Updates user entry in database
     * @param u_id user id
     * @param userSchema {@link UserSchema}
     * @return {@link SecureUserSchema}
     */
    SecureUserSchema updateUser(int u_id, UserSchema userSchema);

    /**
     * Deletes user entry from database
     * @param u_id user id
     */
    void deleteUserById(int u_id);
}
