package org.example.bvito.mappers.users;

import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAdsMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "ads", source = "ads")
    UserAdsSchema toSchema(SecureUserSchema user, List<AdsWithoutUserSchema> ads);

}
