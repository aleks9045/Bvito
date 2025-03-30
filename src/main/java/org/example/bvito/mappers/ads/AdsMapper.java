package org.example.bvito.mappers.ads;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
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

    AdWithoutUserSchema toSchemaWithoutUser(Ads ad);

    /**
     * Maps AdSchema to Ads model
     * @param AdSchema {@link org.example.bvito.schemas.ads.in.AdSchema Advertisement schema}
     * @return {@link Ads Advertisement model}
     */
    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    Ads toEntity(AdSchema adSchema);

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
     * @param adSchema {@link org.example.bvito.schemas.ads.in.AdSchema Advertisement schema}
     * @param ads {@link Ads Advertisement model}
     */
    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(org.example.bvito.schemas.ads.in.AdSchema adSchema, @MappingTarget Ads ads);
}
