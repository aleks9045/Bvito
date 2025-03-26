package org.example.bvito.mappers;


import org.example.bvito.models.Ads;
import org.example.bvito.schemas.AdsSchema;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AdsMapperTests {
    private final AdsMapper adsMapper = AdsMapper.INSTANCE;
    private final Ads ads = Ads.newInstance();
    private final AdsSchema adsSchema = AdsSchema.newInstance();

    @Test
    void toEntityTest() {

        Instant now = Instant.now();
        ads.setCreatedAt(now);

        Ads adsFromSchema = adsMapper.toEntity(adsSchema);
        assertNotNull(adsFromSchema);

        adsFromSchema.setA_id(1);

        assertNotNull(adsFromSchema.getUser());
        assertEquals(adsSchema.getU_id(), adsFromSchema.getUser().getU_id());
        assertEquals(adsSchema.getBrand(), adsFromSchema.getBrand());
        assertEquals(adsSchema.getModel(), adsFromSchema.getModel());
        assertEquals(adsSchema.getYear(), adsFromSchema.getYear());
        assertEquals(adsSchema.getMileage(), adsFromSchema.getMileage());
        assertEquals(adsSchema.getPrice(), adsFromSchema.getPrice());
        assertEquals(adsSchema.getDescription(), adsFromSchema.getDescription());
//        assertEquals(ads, adsFromSchema);
    }

    @Test
    void toSchemaTest() {
        Instant now = Instant.now();
        ads.setCreatedAt(now);

        AdsSchema adsSchemaFromModel = adsMapper.toSchema(ads);
        assertEquals(adsSchema, adsSchemaFromModel);
    }
}
