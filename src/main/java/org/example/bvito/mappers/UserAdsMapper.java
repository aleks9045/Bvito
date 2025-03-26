package org.example.bvito.mappers;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.AdsWithoutUserSchema;
import org.example.bvito.schemas.UserAdsSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAdsMapper {

    @Mapping(target = "user", source = "user")
    @Mapping(target = "adList", source = "adList")
    UserAdsSchema toSchema(Users user, List<AdsWithoutUserSchema> adList);

}
