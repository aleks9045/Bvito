package org.example.bvito.mappers.users;

import org.example.bvito.models.User;
import org.example.bvito.schemas.user.in.UserSchema;
import org.example.bvito.schemas.user.out.SecureUserSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for {@link User} model
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
     * @param user {@link User User model}
     * @return {@link SecureUserSchema Secure user schema}
     */
    SecureUserSchema toSchema(User user);

    /**
     * Maps user schema to user model ignoring user id
     * @param userSchema {@link UserSchema User schema}
     * @return {@link User User model}
     */
    @Mapping(target = "userId", ignore = true)
    User toEntity(UserSchema userSchema);

    /**
     * Updates User model with user schema ignoring null values
     * @param userSchema {@link UserSchema User schema}
     * @param user {@link User User model}
     */
    @Mapping(target = "userId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserSchema userSchema, @MappingTarget User user);

}
