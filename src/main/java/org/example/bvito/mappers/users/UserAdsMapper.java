package org.example.bvito.mappers.users;

import org.example.bvito.models.Users;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 *  Mapper for {@link Users}, {@link Ads} models
 *  <p>
 *  Converting one object to another by transfer first object fields to second object
 *  using setters and getters
 *
 *  @author Aleksey
 */
@Mapper(componentModel = "spring")
public interface UserAdsMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "ads", source = "ads")
    UserAdsSchema toSchema(SecureUserSchema user, List<AdWithoutUserSchema> ads);

}
