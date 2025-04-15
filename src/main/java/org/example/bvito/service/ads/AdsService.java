package org.example.bvito.service.ads;

import org.example.bvito.models.Ad;
import org.example.bvito.schemas.ad.in.AdSchemaIn;
import org.example.bvito.schemas.ad.out.AdSchemaOut;
import org.example.bvito.schemas.ad.out.SecureAdSchema;
import org.example.bvito.service.ads.impl.AdsServiceImpl;

import java.util.List;
import java.util.Map;

/**
 *  A set of methods for business logic with {@link Ad} model
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
    List<AdSchemaOut> getAllAds();

    /**
     * Gets advertisement entry from database
     * @param a_id advertisement id
     * @return ad model
     */
    Ad getAdById(int a_id);

    /**
     * Adds advertisement entry to database
     * @param adSchemaIn {@link AdSchemaIn}
     * @return advertisement model
     */
    Ad addAd(AdSchemaIn adSchemaIn);

    /**
     * Updates advertisement entry in database
     * @param a_id advertisement id
     * @param adSchemaIn advertisement schema {@link AdSchemaIn}
     * @return advertisement model
     */
    Ad updateAd(int a_id, AdSchemaIn adSchemaIn);

    /**
     * Deletes advertisement entry from database
     * @param a_id advertisement id
     */
    void deleteAdById(int a_id);

}
