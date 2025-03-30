package org.example.bvito.service.ads.impl;

import org.example.bvito.mappers.ads.AdsMapper;
import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.Ads;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.schemas.ads.out.AdSchema;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
import org.example.bvito.schemas.ads.out.SecureAdSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.service.ads.AdsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Class which contains all business logic for {@link Ads} model
 * <p>
 * Implementation of {@link AdsService} interface
 * <p>
 * Depends on {@link AdsRepository}, {@link AdsMapper}
 *
 * @author Aleksey
 */
@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final AdsMapper adsMapper;
    private final UsersMapper usersMapper;

    public AdsServiceImpl(AdsRepository adsRepository, AdsMapper adsMapper, UsersMapper usersMapper) {
        this.adsRepository = adsRepository;
        this.adsMapper = adsMapper;
        this.usersMapper = usersMapper;
    }

    public List<AdSchema> getAllAds() {
        Map<SecureAdSchema, List<String>> mapAdPhotos = new HashMap<>();
        adsRepository.findAllWithPhotos().forEach(row -> {
            Ads ad = (Ads) row[0];

            AdWithoutUserSchema adWithoutUserSchema = adsMapper.toSchemaWithoutUser(ad);
            SecureUserSchema secureUserSchema = usersMapper.toSchema(ad.getUser());

            SecureAdSchema secureAdSchema = new SecureAdSchema(adWithoutUserSchema, secureUserSchema);
            String photoUrl = (String) row[1];
            mapAdPhotos.computeIfAbsent(secureAdSchema, k -> new ArrayList<>()).add(photoUrl);
        });

        return mapAdPhotos.entrySet().stream().map(
                entry -> new AdSchema(entry.getKey(), entry.getValue()))
                .toList();
    }

    public Ads getAdById(int a_id) {
        return adsRepository.findById(a_id).orElseThrow(() -> new NoSuchElementException("Ad not found"));
    }

    public Ads addAd(org.example.bvito.schemas.ads.in.AdSchema adSchema) {
        Ads ads = adsMapper.toEntity(adSchema);

        return adsRepository.save(ads);
    }

    @Transactional
    public Ads updateAd(int a_id, org.example.bvito.schemas.ads.in.AdSchema adSchema) {
        Ads existingAd = adsRepository.findById(a_id).orElseThrow();

        adsMapper.updateEntity(adSchema, existingAd);
        return existingAd;
    }

    @Transactional
    public void deleteAdById(int a_id) {
        adsRepository.deleteById(a_id);
    }
}
