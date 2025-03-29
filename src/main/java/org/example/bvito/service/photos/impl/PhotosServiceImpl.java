package org.example.bvito.service.photos.impl;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Photos;
import org.example.bvito.repository.PhotosRepository;
import org.example.bvito.schemas.photos.PhotoSchema;
import org.example.bvito.service.photos.PhotosService;
import org.example.bvito.service.photos.exception.PhotoException;
import org.example.bvito.service.photos.utils.PhotoProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
        this.uploadLocation = Paths.get(photoProperties.getLocation());
        this.photosRepository = photosRepository;
    }


    public String savePhoto(PhotoSchema photoSchema) {
        MultipartFile file = photoSchema.getFile();
        if (file.isEmpty()) {
            throw new PhotoException("File is empty");
        }
        Objects.requireNonNull(file.getOriginalFilename());
        Path destinationPath = uploadLocation.resolve(
                        Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();
        if (!destinationPath.getParent().equals(uploadLocation.toAbsolutePath())) {
            // This is a security check
            throw new PhotoException("Cannot store photo outside upload directory.");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new PhotoException("Failed to save photo");
        }
        Ads ad = new Ads();
        ad.setA_id(photoSchema.getA_id());
        Photos photo = new Photos();
        photo.setAds(ad);
        photo.setUrl(destinationPath.toString());
        photosRepository.save(photo);
        return destinationPath.toString();
    }

    public Path load(String filename) {
        return uploadLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new PhotoException(
                        "Could not find file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new PhotoException(
                    "Could not find file: " + filename, e);
        }
    }
}
