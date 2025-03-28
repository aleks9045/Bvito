package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.AdsValidationGroups;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.example.bvito.service.ads.AdsService;
import org.example.bvito.service.ads.impl.AdsServiceImpl;
import org.example.bvito.service.users.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Ads>> getAllAds() {
        List<Ads> adsList = adsService.getAllAds();
        return ResponseEntity.status(200).body(adsList);
    }

    @PostMapping("/")
    public ResponseEntity<Ads> addAd(@Validated(AdsValidationGroups.OnCreate.class)
                                         @RequestBody AdSchema adSchema) {
        Ads addedAd = adsService.addAd(adSchema);
        return ResponseEntity.created(
                        URI.create("/ads/" + addedAd.getA_id()))
                .body(addedAd);
    }

    @GetMapping("/{a_id}")
    public ResponseEntity<Ads> getAd(@PathVariable("a_id") int a_id) {
        Ads user = adsService.getAdById(a_id);

            return ResponseEntity.ok().body(user);

    }

    @PatchMapping("/{a_id}")
    public ResponseEntity<Ads> patchAd(@PathVariable("a_id") int a_id,
                                       @Validated(AdsValidationGroups.OnUpdate.class)
                                       @RequestBody AdSchema adSchema) {
        Ads updatedAd = adsService.updateAd(a_id, adSchema);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ads/" + updatedAd.getA_id());

        return ResponseEntity.status(200).headers(headers).body(updatedAd);
    }

    @DeleteMapping("/{a_id}")
    public ResponseEntity deleteAd(@PathVariable("a_id") int a_id) {
        adsService.deleteAdById(a_id);
        return ResponseEntity.ok().build();
    }
}
