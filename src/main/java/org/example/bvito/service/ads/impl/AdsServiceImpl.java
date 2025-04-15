package org.example.bvito.service.ads.impl;

import org.example.bvito.mappers.ads.AdsMapper;
import org.example.bvito.mappers.users.UsersMapper;
import org.example.bvito.models.Ad;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.schemas.ad.out.AdSchemaOut;
import org.example.bvito.schemas.ad.out.AdWithoutUserSchema;
import org.example.bvito.schemas.ad.out.SecureAdSchema;
import org.example.bvito.schemas.user.out.SecureUserSchema;
import org.example.bvito.service.ads.AdsService;
import org.springframework.stereotype.Service;
import org.example.bvito.schemas.ad.in.AdSchemaIn;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Class which contains all business logic for {@link Ad} model
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

    public List<AdSchemaOut> getAllAds() {
        Map<SecureAdSchema, List<String>> mapAdPhotos = new HashMap<>();
        this.mergeAdPhotos(mapAdPhotos);

        return mapAdPhotos.entrySet().stream().map(
                entry -> new AdSchemaOut(entry.getKey(), entry.getValue()))
                .toList();
    }

    private void mergeAdPhotos(Map<SecureAdSchema, List<String>> mapAdPhotos) {
        adsRepository.findAllWithPhotos().forEach(row -> {
            Ad ad = (Ad) row[0];

            AdWithoutUserSchema adWithoutUserSchema = adsMapper.toSchemaWithoutUser(ad);
            SecureUserSchema secureUserSchema = usersMapper.toSchema(ad.getUser());

            SecureAdSchema secureAdSchema = new SecureAdSchema(adWithoutUserSchema, secureUserSchema);
            String photoUrl = (String) row[1];
            mapAdPhotos.computeIfAbsent(secureAdSchema, k -> new ArrayList<>()).add(photoUrl);
        });
    }

    public Ad getAdById(int a_id) {
        return adsRepository.findById(a_id).orElseThrow(() -> new NoSuchElementException("Ad not found"));
    }

    public Ad addAd(AdSchemaIn adSchemaIn) {
        Ad ad = adsMapper.toEntity(adSchemaIn);

        return adsRepository.save(ad);
    }

    @Transactional
    public Ad updateAd(int a_id, AdSchemaIn adSchemaIn) {
        Ad existingAd = adsRepository.findById(a_id).orElseThrow();

        adsMapper.updateEntity(adSchemaIn, existingAd);
        return existingAd;
    }

    @Transactional
    public void deleteAdById(int a_id) {
        adsRepository.deleteById(a_id);
    }
}
