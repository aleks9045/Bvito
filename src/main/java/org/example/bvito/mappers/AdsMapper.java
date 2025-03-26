package org.example.bvito.mappers;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.AdsSchema;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(target = "u_id", source = "user")
    AdsSchema toSchema(Ads Ads);

    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    Ads toEntity(AdsSchema AdsSchema);

    @Mapping(target = "u_id", source = "users")
    List<AdsSchema> toSchemaList(List<Ads> AdsList);

    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    List<Ads> toEntityList(List<AdsSchema> AdsSchemaList);

    default Users mapUserIdToUsers(Integer u_id) {
        if (u_id == null) {return null;}
        Users user = new Users();
        user.setU_id(u_id);
        return user;
    }
    default Integer mapUserIdToUsers(Users users) {
        if (users == null) {return null;}
        return users.getU_id();
    }
}
