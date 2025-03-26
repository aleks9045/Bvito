package org.example.bvito.service;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.AdsSchema;
import org.example.bvito.schemas.UsersSchema;

import java.util.List;
import java.util.Optional;

public interface AdsService {
    List<Ads> getAllAds();

    Optional<Ads> getAdsById(int a_id);

    Ads addAds(AdsSchema adsSchema);

    Ads updateAds(int a_id, AdsSchema adsSchema);

    void deleteAdsById(int a_id);
}
