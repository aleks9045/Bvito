package org.example.bvito.mappers;


import org.example.bvito.models.Users;
import org.example.bvito.schemas.UsersSchema;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UsersMapperTests {
    private final UsersMapper usersMapper = UsersMapper.INSTANCE;

    @Test
    void toEntityTest() {
        Users users = Users.newInstance();

        UsersSchema usersSchema = UsersSchema.newInstance();

        Users usersFromSchema = usersMapper.toEntity(usersSchema);
        usersFromSchema.setU_id(1);
        assertEquals(users, usersFromSchema);
    }
}
