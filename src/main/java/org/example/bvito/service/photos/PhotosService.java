package org.example.bvito.service.photos;

import org.example.bvito.schemas.photos.PhotoSchema;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * @author Aleksey
 */
public interface PhotosService {
    String savePhoto(PhotoSchema photoSchema);

    Path load(String filename);
    Resource loadAsResource(String filename);
}
