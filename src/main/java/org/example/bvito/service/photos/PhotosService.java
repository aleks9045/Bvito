package org.example.bvito.service.photos;

import org.example.bvito.schemas.photos.in.PhotoSchema;

/**
 * @author Aleksey
 */
public interface PhotosService {
    String savePhoto(PhotoSchema photoSchema);

}
