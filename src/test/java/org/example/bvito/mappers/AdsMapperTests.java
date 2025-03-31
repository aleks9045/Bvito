package org.example.bvito.mappers;


import org.example.bvito.mappers.ads.AdsMapper;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.in.AdSchemaIn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *  @author Aleksey
 */
public class AdsMapperTests {
    private final AdsMapper adsMapper = AdsMapper.INSTANCE;
    private final Ads ads = Ads.newInstance();
    private final AdSchemaIn adSchemaIn = AdSchemaIn.newInstance();

    @Test
    void toEntityTest() {

        Ads adsFromSchema = adsMapper.toEntity(adSchemaIn);
        assertNotNull(adsFromSchema);

        adsFromSchema.setA_id(1);

        assertNotNull(adsFromSchema.getUser());
        assertEquals(adSchemaIn.getU_id(), adsFromSchema.getUser().getU_id());
        assertEquals(adSchemaIn.getBrand(), adsFromSchema.getBrand());
        assertEquals(adSchemaIn.getModel(), adsFromSchema.getModel());
        assertEquals(adSchemaIn.getYear(), adsFromSchema.getYear());
        assertEquals(adSchemaIn.getMileage(), adsFromSchema.getMileage());
        assertEquals(adSchemaIn.getPrice(), adsFromSchema.getPrice());
        assertEquals(adSchemaIn.getDescription(), adsFromSchema.getDescription());
//        assertEquals(ads, adsFromSchema);
    }

    @Test
    void updateEntityTest() {
        Ads adsToUpdate = Ads.newInstance();
        adsToUpdate.setBrand("NOT KIA");
        adsToUpdate.setModel("NOT K5");
        adsToUpdate.setYear((short) 1000);
        adsMapper.updateEntity(adSchemaIn, adsToUpdate);

        assertEquals(adSchemaIn.getBrand(), adsToUpdate.getBrand());
        assertEquals(adSchemaIn.getModel(), adsToUpdate.getModel());
        assertEquals(adSchemaIn.getYear(), adsToUpdate.getYear());
    }
}
