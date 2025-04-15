package org.example.bvito.mappers.ads;

import org.example.bvito.models.Ad;
import org.example.bvito.models.User;
import org.example.bvito.schemas.ad.in.AdSchemaIn;
import org.example.bvito.schemas.ad.out.AdWithoutUserSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


/**
 *  Mapper for {@link Ad} model
 *  <p>
 *  Converting one object to another by transfer first object fields to second object
 *  using setters and getters
 *  @author Aleksey
 */
@Mapper(componentModel = "spring")
public interface AdsMapper {
    // For testing
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    AdWithoutUserSchema toSchemaWithoutUser(Ad ad);

    /**
     * Maps AdSchema to Ads model
     * @param adSchemaIn {@link AdSchemaIn Advertisement schema}
     * @return {@link Ad Advertisement model}
     */
    @Mapping(target = "adId", ignore = true)
    @Mapping(target = "user", source = "userId")
    Ad toEntity(AdSchemaIn adSchemaIn);

    /**
     * Maps user id to Users model with id set
     * @param userId user id
     * @return {@link User User model}
     */
    default User mapUserIdToUsers(Integer userId) {
        if (userId == null) {return null;}
        User user = new User();
        user.setUserId(userId);
        return user;
    }

    /**
     * Maps Users model to integer id
     * @param user {@link User User model}
     * @return user id
     */
    default Integer mapUserIdToUsers(User user) {
        if (user == null) {return null;}
        return user.getUserId();
    }

    /**
     * Updates Ads model with Advertisement schema ignoring null values
     * @param adSchemaIn {@link AdSchemaIn Advertisement schema}
     * @param ad {@link Ad Advertisement model}
     */
    @Mapping(target = "adId", ignore = true)
    @Mapping(target = "user", source = "userId")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AdSchemaIn adSchemaIn, @MappingTarget Ad ad);
}
