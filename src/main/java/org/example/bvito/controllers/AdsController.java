package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.bvito.models.Ads;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.AdsSchema;
import org.example.bvito.service.impl.AdsServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Ads> addAd(@Valid @RequestBody AdsSchema adsSchema) {
        Ads addedAd = adsService.addAds(adsSchema);
        return ResponseEntity.created(
                        URI.create("/ads/" + addedAd.getA_id()))
                .body(addedAd);
    }

    @GetMapping("/{a_id}")
    public ResponseEntity<Optional<Ads>> getAd(@PathVariable("a_id") int a_id) {
        Optional<Ads> user = adsService.getAdsById(a_id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }

    @PutMapping("/{a_id}")
    public ResponseEntity<Ads> putAd(@PathVariable("a_id") int a_id, @Valid @RequestBody AdsSchema adsSchema) {
        Ads updatedAd = adsService.updateAds(a_id, adsSchema);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ads/" + updatedAd.getA_id());

        return ResponseEntity.status(200).headers(headers).body(updatedAd);
    }

    @DeleteMapping("/{a_id}")
    public ResponseEntity deleteAd(@PathVariable("a_id") int a_id) {
        adsService.deleteAdsById(a_id);
        return ResponseEntity.ok().build();
    }
}
