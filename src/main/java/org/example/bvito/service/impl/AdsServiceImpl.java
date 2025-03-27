package org.example.bvito.service.impl;

import org.example.bvito.mappers.AdsMapper;
import org.example.bvito.models.Ads;
import org.example.bvito.repository.AdsRepository;
import org.example.bvito.schemas.ads.in.AdSchema;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.example.bvito.service.AdsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Optional<Ads> getAdById(int a_id) {
        return adsRepository.findById(a_id);
    }

    public Ads addAd(AdSchema adSchema) {
        Ads ads = adsMapper.toEntity(adSchema);

        return adsRepository.save(ads);
    }

    @Transactional
    public Ads updateAd(int a_id, AdSchema adSchema) {
        Ads existingAd = adsRepository.findById(a_id).orElseThrow();

        adsMapper.updateEntity(adSchema, existingAd);
        return existingAd;
    }

    @Transactional
    public void deleteAdById(int a_id) {
        adsRepository.deleteById(a_id);
    }
}
