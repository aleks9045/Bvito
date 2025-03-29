package org.example.bvito.mappers.users;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for {@link Users} model
 * <p>
 *  Converting one object to another by transfer first object fields to second object
 *  using setters and getters
 *  @author Aleksey
 */
@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    /**
     * Maps user model to secure schema
     * @param users {@link Users User model}
     * @return {@link SecureUserSchema Secure user schema}
     */
    @Mapping(source = "userName", target = "user_name")
    @Mapping(source = "phoneNumber", target = "phone_number")
    SecureUserSchema toSchema(Users users);

    /**
     * Maps user schema to user model ignoring user id
     * @param userSchema {@link UserSchema User schema}
     * @return {@link Users User model}
     */
    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    Users toEntity(UserSchema userSchema);

    /**
     * Updates User model with user schema ignoring null values
     * @param userSchema {@link UserSchema User schema}
     * @param user {@link Users User model}
     */
    @Mapping(target = "u_id", ignore = true)
    @Mapping(source = "user_name", target = "userName")
    @Mapping(source = "phone_number", target = "phoneNumber")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserSchema userSchema, @MappingTarget Users user);

}
