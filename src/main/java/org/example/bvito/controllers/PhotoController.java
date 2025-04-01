package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.ContentType;
import org.example.bvito.schemas.photos.in.PhotoSchema;
import org.example.bvito.models.Photos;
import org.example.bvito.service.photos.PhotosService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Rest controller for photo operations (CRUD)
 * <p>
 * Process HTTP requests to work with {@link Photos} model
 * Every method returns data in JSON format
 *
 * @author Aleksey
 * @see PhotosService Service layer interface for business logic
 * @see Photos Photo model
 */
@RestController
@RequestMapping("api/v1/photos")
@Tag(name = "Photos")
public class PhotoController {
    private final PhotosService photosService;

    public PhotoController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadPhoto(
            @RequestParam("ad_id") int adId,
            @RequestPart(value = "file") MultipartFile file) {

        String savedUrl = photosService.savePhoto(adId, file);
        return ResponseEntity.status(200).header("Location", savedUrl).build();
    }

    @DeleteMapping("/{photo_name}")
    public ResponseEntity<?> deletePhoto(@PathVariable("photo_name") String photoName) {

        photosService.deletePhoto(photoName);
        return ResponseEntity.status(200).build();
    }
}

