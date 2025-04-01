package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.AdsValidationGroups;
import org.example.bvito.schemas.ads.in.AdSchemaIn;
import org.example.bvito.schemas.ads.out.AdSchemaOut;
import org.example.bvito.service.ads.AdsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 *  Rest controller for ads operations (CRUD)
 *  <p>
 *  Process HTTP requests to work with {@link Ads} model
 *  Every method returns data in JSON format
 *
 *  @author Aleksey
 *
 * @see AdsService Service layer for interface business logic
 * @see Ads Ad model
 */
@RestController
@RequestMapping(path = "/api/v1/ads")
@Tag(name = "Ads")
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdSchemaOut>> getAllAds() {
        List<AdSchemaOut> adsList = adsService.getAllAds();
        return ResponseEntity.status(200).body(adsList);
    }

    @PostMapping("/")
    public ResponseEntity<Ads> addAd(@Validated(AdsValidationGroups.OnCreate.class)
                                         @RequestBody AdSchemaIn adSchemaIn) {
        Ads addedAd = adsService.addAd(adSchemaIn);
        return ResponseEntity.created(
                        URI.create("/ads/" + addedAd.getAdId()))
                .body(addedAd);
    }

    @GetMapping("/{ad_id}")
    public ResponseEntity<Ads> getAd(@PathVariable("ad_id") int ad_id) {
        Ads ad = adsService.getAdById(ad_id);
            return ResponseEntity.ok().body(ad);

    }

    @PatchMapping("/{ad_id}")
    public ResponseEntity<Ads> patchAd(@PathVariable("ad_id") int ad_id,
                                       @Validated(AdsValidationGroups.OnUpdate.class)
                                       @RequestBody AdSchemaIn adSchemaIn) {
        Ads updatedAd = adsService.updateAd(ad_id, adSchemaIn);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ads/" + updatedAd.getAdId());

        return ResponseEntity.status(200).headers(headers).body(updatedAd);
    }

    @DeleteMapping("/{ad_id}")
    public ResponseEntity deleteAd(@PathVariable("ad_id") int ad_id) {
        adsService.deleteAdById(ad_id);
        return ResponseEntity.ok().build();
    }
}
