package org.example.bvito.mappers.ads;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.in.AdSchemaIn;
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
     * @param adSchemaIn {@link AdSchemaIn Advertisement schema}
     * @return {@link Ads Advertisement model}
     */
    @Mapping(target = "adId", ignore = true)
    @Mapping(target = "user", source = "userId")
    Ads toEntity(AdSchemaIn adSchemaIn);

    /**
     * Maps user id to Users model with id set
     * @param userId user id
     * @return {@link Users User model}
     */
    default Users mapUserIdToUsers(Integer userId) {
        if (userId == null) {return null;}
        Users user = new Users();
        user.setUserId(userId);
        return user;
    }

    /**
     * Maps Users model to integer id
     * @param users {@link Users User model}
     * @return user id
     */
    default Integer mapUserIdToUsers(Users users) {
        if (users == null) {return null;}
        return users.getUserId();
    }

    /**
     * Updates Ads model with Advertisement schema ignoring null values
     * @param adSchemaIn {@link AdSchemaIn Advertisement schema}
     * @param ads {@link Ads Advertisement model}
     */
    @Mapping(target = "adId", ignore = true)
    @Mapping(target = "user", source = "userId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AdSchemaIn adSchemaIn, @MappingTarget Ads ads);
}
