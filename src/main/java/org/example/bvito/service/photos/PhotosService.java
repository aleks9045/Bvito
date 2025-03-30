package org.example.bvito.service.photos;

import org.example.bvito.models.Photos;
import org.example.bvito.schemas.photos.in.PhotoSchema;
import org.example.bvito.service.photos.impl.PhotosServiceImpl;

/**
 *  A set of methods for business logic with {@link Photos} model
 *
 *  @author Aleksey
 *
 *  @see PhotosServiceImpl implementation of this interface
 */
public interface PhotosService {
    String savePhoto(PhotoSchema photoSchema);
}
