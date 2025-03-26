package org.example.bvito.service.impl;

import org.example.bvito.mappers.AdsMapper;
import org.example.bvito.models.Ads;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.schemas.AdsSchema;
import org.example.bvito.schemas.UsersSchema;
import org.example.bvito.service.AdsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository adsRepository;
    private final AdsMapper adsMapper;

    public AdsServiceImpl(AdsRepository adsRepository, AdsMapper adsMapper) {
        this.adsRepository = adsRepository;
        this.adsMapper = adsMapper;
    }

    public List<Ads> getAllAds() {
        return adsRepository.findAll();
    }

    public Optional<Ads> getAdsById(int a_id) {
        return adsRepository.findById(a_id);
    }

    public Ads addAds(AdsSchema adsSchema) {
        Ads ads = adsMapper.toEntity(adsSchema);
        return adsRepository.save(ads);
    }

    public Ads updateAds(int a_id, AdsSchema adsSchema) {
        Ads ads = adsMapper.toEntity(adsSchema);
        ads.setA_id(a_id);
        return adsRepository.save(ads);
    }

    public void deleteAdsById(int a_id) {
        adsRepository.deleteById(a_id);
    }
}
