package org.example.bvito.mappers;


import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  @author Aleksey
 */
public class UsersMapperTests {
    private final UsersMapper usersMapper = UsersMapper.INSTANCE;

    @Test
    void toEntityTest() {
        Users users = Users.newInstance();
        UserSchema userSchema = UserSchema.newInstance();

        Users usersFromSchema = usersMapper.toEntity(userSchema);
        usersFromSchema.setU_id(1);

        assertEquals(users, usersFromSchema);
    }

    @Test
    void toSchemaTest() {
        Users users = Users.newInstance();
        SecureUserSchema userSchema = SecureUserSchema.newInstance();

        SecureUserSchema userSchemaFromModel = usersMapper.toSchema(users);
        assertEquals(userSchema, userSchemaFromModel);
    }
}
