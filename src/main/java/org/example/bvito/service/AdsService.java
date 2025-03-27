package org.example.bvito.service;

import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.in.AdSchema;

import java.util.List;
import java.util.Optional;

public interface AdsService {
    List<Ads> getAllAds();

    Optional<Ads> getAdById(int a_id);

    Ads addAd(AdSchema adSchema);

    Ads updateAd(int a_id, AdSchema adSchema);

    void deleteAdById(int a_id);
}
