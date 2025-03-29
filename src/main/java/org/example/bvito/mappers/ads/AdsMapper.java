package org.example.bvito.mappers.ads;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 *  Mapper for {@link Ads} model
 *  <p>
 *  Converting one object to another by transfer first object fields to second object
 *  using setters and getters
 *  @author Aleksey
 */
@Mapper(componentModel = "spring")
public interface AdsMapper {
    // For testing
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    /**
     * Maps Ads model to AdSchema
     * @param Ads {@link Ads Advertisement model}
     * @return {@link AdSchema}
     */
    @Mapping(target = "u_id", source = "user")
    AdSchema toSchema(Ads Ads);

    /**
     * Maps AdSchema to Ads model
     * @param AdSchema {@link AdSchema Advertisement schema}
     * @return {@link Ads Advertisement model}
     */
    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    Ads toEntity(AdSchema AdSchema);

    /**
     * Maps user id to Users model with id set
     * @param u_id user id
     * @return {@link Users User model}
     */
    default Users mapUserIdToUsers(Integer u_id) {
        if (u_id == null) {return null;}
        Users user = new Users();
        user.setU_id(u_id);
        return user;
    }

    /**
     * Maps Users model to integer id
     * @param users {@link Users User model}
     * @return user id
     */
    default Integer mapUserIdToUsers(Users users) {
        if (users == null) {return null;}
        return users.getU_id();
    }

    /**
     * Updates Ads model with Advertisement schema ignoring null values
     * @param adSchema {@link AdSchema Advertisement schema}
     * @param ads {@link Ads Advertisement model}
     */
    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AdSchema adSchema, @MappingTarget Ads ads);
}
