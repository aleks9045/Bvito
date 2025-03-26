package org.example.bvito.mappers;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.UsersSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);


    @Mapping(source = "userName", target = "user_name")
    @Mapping(source = "phoneNumber", target = "phone_number")
    UsersSchema toSchema(Users users);

    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    Users toEntity(UsersSchema usersSchema);

    @Mapping(source = "userName", target = "user_name")
    @Mapping(source = "phoneNumber", target = "phone_number")
    List<UsersSchema> toSchemaList(List<Users> usersList);

    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    List<Users> toEntityList(List<UsersSchema> usersSchemaList);
}
