package org.example.bvito.service.photos.impl;

import jakarta.annotation.PostConstruct;
import org.example.bvito.models.Ads;
import org.example.bvito.models.Photos;
import org.example.bvito.repository.PhotosRepository;
import org.example.bvito.schemas.photos.in.PhotoSchema;
import org.example.bvito.service.photos.PhotosService;
import org.example.bvito.service.photos.exception.PhotoException;
import org.example.bvito.service.photos.utils.PhotoProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * Class which contains all business logic for {@link Photos} model
 * <p>
 * Implementation of {@link PhotosService} interface
 * <p>
 * Depends on {@link PhotosRepository}
 * @author Aleksey
 */
@Service
public class PhotosServiceImpl implements PhotosService {
    private final Path uploadLocation;
    private final PhotosRepository photosRepository;

    public PhotosServiceImpl(PhotoProperties photoProperties, PhotosRepository photosRepository) {
        this.uploadLocation = Paths.get(photoProperties.getLocation()).normalize();
        this.photosRepository = photosRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        Files.createDirectories(uploadLocation);
    }

    public String savePhoto(int ad_id, MultipartFile file) {

        if (photosRepository.countByAdId(ad_id) > 4) {
            throw new PhotoException("There are already 5 photos");
        }
        if (file.isEmpty()) {
            throw new PhotoException("File is empty");
        }
        Objects.requireNonNull(file.getOriginalFilename());
        Path destinationPath = uploadLocation.resolve(
                        Paths.get(file.getOriginalFilename())).toAbsolutePath().normalize();
        System.out.println(destinationPath);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new PhotoException("Failed to save photo");
        }

        String urlForDB = "/ad_photos/" + file.getOriginalFilename();
        this.saveToDB(ad_id, urlForDB);

        return urlForDB;
    }

    @Transactional
    public void deletePhoto(String photoName) {
        Path destinationPath = uploadLocation.resolve(photoName).normalize();
        try {
            Files.delete(destinationPath);
        } catch (IOException e) {
            throw new PhotoException("Failed to delete photo");
        }
        photosRepository.deleteByUrl("/ad_photos/" + photoName);
    }

    public void saveToDB(int a_id, String url) {

        Ads ad = new Ads();
        ad.setAdId(a_id);
        ad.setCreatedAt(null);

        Photos photo = new Photos();
        photo.setaAd(ad);
        photo.setUrl(url);
        photosRepository.save(photo);
    }

}
