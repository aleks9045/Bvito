package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Ad;
import org.example.bvito.schemas.ad.AdsValidationGroups;
import org.example.bvito.schemas.ad.in.AdSchemaIn;
import org.example.bvito.schemas.ad.out.AdSchemaOut;
import org.example.bvito.service.ads.AdsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 *  Rest controller for ads operations (CRUD)
 *  <p>
 *  Process HTTP requests to work with {@link Ad} model
 *  Every method returns data in JSON format
 *
 *  @author Aleksey
 *
 * @see AdsService Service layer for interface business logic
 * @see Ad Ad model
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
        return ResponseEntity.status(HttpStatus.OK).body(adsList);
    }

    @PostMapping("/")
    public ResponseEntity<Ad> addAd(@Validated(AdsValidationGroups.OnCreate.class)
                                         @RequestBody AdSchemaIn adSchemaIn) {
        Ad addedAd = adsService.addAd(adSchemaIn);
        return ResponseEntity.created(
                        URI.create("/ads/" + addedAd.getAdId()))
                .body(addedAd);
    }

    @GetMapping("/{ad_id}")
    public ResponseEntity<Ad> getAd(@PathVariable("ad_id") int ad_id) {
        Ad ad = adsService.getAdById(ad_id);
            return ResponseEntity.ok().body(ad);

    }

    @PatchMapping("/{ad_id}")
    public ResponseEntity<Ad> patchAd(@PathVariable("ad_id") int ad_id,
                                      @Validated(AdsValidationGroups.OnUpdate.class)
                                       @RequestBody AdSchemaIn adSchemaIn) {
        Ad updatedAd = adsService.updateAd(ad_id, adSchemaIn);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ads/" + updatedAd.getAdId());

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(updatedAd);
    }

    @DeleteMapping("/{ad_id}")
    public ResponseEntity deleteAd(@PathVariable("ad_id") int ad_id) {
        adsService.deleteAdById(ad_id);
        return ResponseEntity.ok().build();
    }
}
