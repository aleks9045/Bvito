package org.example.bvito.mappers;


import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AdsMapperTests {
    private final AdsMapper adsMapper = AdsMapper.INSTANCE;
    private final Ads ads = Ads.newInstance();
    private final AdSchema adSchema = AdSchema.newInstance();

    @Test
    void toEntityTest() {

        Instant now = Instant.now();
        ads.setCreatedAt(now);

        Ads adsFromSchema = adsMapper.toEntity(adSchema);
        assertNotNull(adsFromSchema);

        adsFromSchema.setA_id(1);

        assertNotNull(adsFromSchema.getUser());
        assertEquals(adSchema.getU_id(), adsFromSchema.getUser().getU_id());
        assertEquals(adSchema.getBrand(), adsFromSchema.getBrand());
        assertEquals(adSchema.getModel(), adsFromSchema.getModel());
        assertEquals(adSchema.getYear(), adsFromSchema.getYear());
        assertEquals(adSchema.getMileage(), adsFromSchema.getMileage());
        assertEquals(adSchema.getPrice(), adsFromSchema.getPrice());
        assertEquals(adSchema.getDescription(), adsFromSchema.getDescription());
//        assertEquals(ads, adsFromSchema);
    }

    @Test
    void toSchemaTest() {
        Instant now = Instant.now();
        ads.setCreatedAt(now);

        AdSchema adSchemaFromModel = adsMapper.toSchema(ads);
        assertEquals(adSchema, adSchemaFromModel);
    }
}
