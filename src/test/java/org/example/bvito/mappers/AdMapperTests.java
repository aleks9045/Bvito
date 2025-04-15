package org.example.bvito.mappers;


import org.example.bvito.mappers.ads.AdsMapper;
import org.example.bvito.models.Ad;
import org.example.bvito.schemas.ad.in.AdSchemaIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *  @author Aleksey
 */
public class AdMapperTests {
    private final AdsMapper adsMapper = AdsMapper.INSTANCE;
    private final Ad ad = Ad.newInstance();
    private final AdSchemaIn adSchemaIn = AdSchemaIn.newInstance();

    @Test
    void toEntityTest() {

        Ad adFromSchema = adsMapper.toEntity(adSchemaIn);
        assertNotNull(adFromSchema);

        adFromSchema.setAdId(1);

        assertNotNull(adFromSchema.getUser());
        assertEquals(adSchemaIn.getUserId(), adFromSchema.getUser().getUserId());
        assertEquals(adSchemaIn.getBrand(), adFromSchema.getBrand());
        assertEquals(adSchemaIn.getModel(), adFromSchema.getModel());
        assertEquals(adSchemaIn.getYear(), adFromSchema.getYear());
        assertEquals(adSchemaIn.getMileage(), adFromSchema.getMileage());
        assertEquals(adSchemaIn.getPrice(), adFromSchema.getPrice());
        assertEquals(adSchemaIn.getDescription(), adFromSchema.getDescription());
//        assertEquals(ads, adsFromSchema);
    }

    @Test
    void updateEntityTest() {
        Ad adToUpdate = Ad.newInstance();
        adToUpdate.setBrand("NOT KIA");
        adToUpdate.setModel("NOT K5");
        adToUpdate.setYear((short) 1000);
        adsMapper.updateEntity(adSchemaIn, adToUpdate);

        assertEquals(adSchemaIn.getBrand(), adToUpdate.getBrand());
        assertEquals(adSchemaIn.getModel(), adToUpdate.getModel());
        assertEquals(adSchemaIn.getYear(), adToUpdate.getYear());
    }
}
