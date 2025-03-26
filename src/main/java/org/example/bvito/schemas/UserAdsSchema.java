package org.example.bvito.schemas;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;

import java.util.List;

public class UserAdsSchema {
    private Users user;
    private List<AdsWithoutUserSchema> adList;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<AdsWithoutUserSchema> getAdList() {
        return adList;
    }

    public void setAdList(List<AdsWithoutUserSchema> adList) {
        this.adList = adList;
    }
}
