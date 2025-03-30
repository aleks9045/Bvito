package org.example.bvito.service.ads;

import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.out.AdSchema;
import org.example.bvito.service.ads.impl.AdsServiceImpl;

import java.util.List;

/**
 *  A set of methods for business logic with {@link Ads} model
 *
 *  @author Aleksey
 *
 *  @see AdsServiceImpl implementation of this interface
 */
public interface AdsService {
    /**
     * Gets all advertisement entries from database
     * @return list of advertisement models
     */
    List<AdSchema> getAllAds();

    /**
     * Gets advertisement entry from database
     * @param a_id advertisement id
     * @return ad model
     */
    Ads getAdById(int a_id);

    /**
     * Adds advertisement entry to database
     * @param adSchema {@link org.example.bvito.schemas.ads.in.AdSchema}
     * @return advertisement model
     */
    Ads addAd(org.example.bvito.schemas.ads.in.AdSchema adSchema);

    /**
     * Updates advertisement entry in database
     * @param a_id advertisement id
     * @param adSchema advertisement schema {@link org.example.bvito.schemas.ads.in.AdSchema}
     * @return advertisement model
     */
    Ads updateAd(int a_id, org.example.bvito.schemas.ads.in.AdSchema adSchema);

    /**
     * Deletes advertisement entry from database
     * @param a_id advertisement id
     */
    void deleteAdById(int a_id);
}
