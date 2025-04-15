package org.example.bvito.mappers;


import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.User;
import org.example.bvito.schemas.user.in.UserSchema;
import org.example.bvito.schemas.user.out.SecureUserSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  @author Aleksey
 */
public class UserMapperTests {
    private final UsersMapper usersMapper = UsersMapper.INSTANCE;

    @Test
    void toEntityTest() {
        User user = User.newInstance();
        UserSchema userSchema = UserSchema.newInstance();

        User userFromSchema = usersMapper.toEntity(userSchema);
        userFromSchema.setUserId(1);

        assertEquals(user, userFromSchema);
    }

    @Test
    void toSchemaTest() {
        User user = User.newInstance();
        SecureUserSchema userSchema = SecureUserSchema.newInstance();

        SecureUserSchema userSchemaFromModel = usersMapper.toSchema(user);
        assertEquals(userSchema, userSchemaFromModel);
    }
}
