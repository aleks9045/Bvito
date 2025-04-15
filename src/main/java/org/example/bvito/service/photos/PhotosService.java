package org.example.bvito.service.photos;

import org.example.bvito.models.Photo;
import org.example.bvito.service.photos.impl.PhotosServiceImpl;
import org.springframework.web.multipart.MultipartFile;

/**
 *  A set of methods for business logic with {@link Photo} model
 *
 *  @author Aleksey
 *
 *  @see PhotosServiceImpl implementation of this interface
 */
public interface PhotosService {
    String savePhoto(int ad_id, MultipartFile file);
    void deletePhoto(String photoName);
}
