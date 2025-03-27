package org.example.bvito.schemas.users.out;

import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;

import java.util.List;

public class UserAdsSchema {
    private Users user;
    private List<AdsWithoutUserSchema> ads;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<AdsWithoutUserSchema> getAds() {
        return ads;
    }

    public void setAds(List<AdsWithoutUserSchema> ads) {
        this.ads = ads;
    }
}
