package org.example.bvito.mappers.ads;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdsMapper {
    AdsMapper INSTANCE = Mappers.getMapper(AdsMapper.class);

    @Mapping(target = "u_id", source = "user")
    AdSchema toSchema(Ads Ads);

    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    Ads toEntity(AdSchema AdSchema);

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

    @Mapping(target = "a_id", ignore = true)
    @Mapping(target = "user", source = "u_id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AdSchema adSchema, @MappingTarget Ads ads);
}
