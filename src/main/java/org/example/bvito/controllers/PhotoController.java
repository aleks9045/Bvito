package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.example.bvito.models.Ads;
import org.example.bvito.schemas.photos.PhotoSchema;
import org.example.bvito.models.Photos;
import org.example.bvito.service.photos.PhotosService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  Rest controller for photo operations (CRUD)
 *  <p>
 *  Process HTTP requests to work with {@link Photos} model
 *  Every method returns data in JSON format
 *
 *  @author Aleksey
 *
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
    public ResponseEntity<?> uploadPhoto(@Validated @ModelAttribute PhotoSchema photoSchema){

        String savedUrl = photosService.savePhoto(photoSchema);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = photosService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
