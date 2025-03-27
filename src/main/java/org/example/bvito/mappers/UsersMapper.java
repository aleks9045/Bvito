package org.example.bvito.mappers;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.UsersValidationGroups;
import org.example.bvito.schemas.users.in.UserSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);


    @Mapping(source = "userName", target = "user_name")
    @Mapping(source = "phoneNumber", target = "phone_number")
    UserSchema toSchema(Users users);

    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    Users toEntity(UserSchema userSchema);

    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserSchema userSchema, @MappingTarget Users user);
}
