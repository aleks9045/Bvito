package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.ads.AdsValidationGroups;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.example.bvito.service.impl.AdsServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/ads")
@Tag(name = "Ads")
public class AdsController {
    private final AdsServiceImpl adsService;

    public AdsController(AdsServiceImpl adsService) {
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
    public ResponseEntity<Optional<Ads>> getAd(@PathVariable("a_id") int a_id) {
        Optional<Ads> user = adsService.getAdById(a_id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
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
