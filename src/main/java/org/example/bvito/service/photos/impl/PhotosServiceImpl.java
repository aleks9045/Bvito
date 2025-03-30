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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

/**
 * @author Aleksey
 */
@Service
public class PhotosServiceImpl implements PhotosService {
    private final Path uploadLocation;
    private final PhotosRepository photosRepository;

    public PhotosServiceImpl(PhotoProperties photoProperties, PhotosRepository photosRepository) {
        this.uploadLocation = Paths.get(photoProperties.getLocation()).toAbsolutePath().normalize();
        this.photosRepository = photosRepository;
    }

    @PostConstruct
    public void init() throws IOException {
        Files.createDirectories(uploadLocation);
    }

    public String savePhoto(PhotoSchema photoSchema) {
        MultipartFile file = photoSchema.getFile();
        if (file.isEmpty()) {
            throw new PhotoException("File is empty");
        }
        Objects.requireNonNull(file.getOriginalFilename());
        Path destinationPath = uploadLocation.resolve(
                        Paths.get(file.getOriginalFilename())).normalize();

        if (!destinationPath.getParent().equals(uploadLocation)) {
            // This is a security check
            throw new PhotoException("Cannot store photo outside upload directory.");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new PhotoException("Failed to save photo");
        }

        String urlForDB = "/ad_photos/" + file.getOriginalFilename();
        this.saveToDB(photoSchema.getA_id(), urlForDB);

        return urlForDB;
    }

    public void saveToDB(int a_id, String url){
        Ads ad = new Ads();
        ad.setA_id(a_id);
        ad.setCreatedAt(null);

        Photos photo = new Photos();
        photo.setAds(ad);
        photo.setUrl(url);
        photosRepository.save(photo);
    }
}
