package org.example.bvito.service.photos.exception;

import org.example.bvito.models.Photos;

/**
 * @author Aleksey
 */
public class PhotoException extends RuntimeException {

    public PhotoException(String message){
        super(message);
    }
    public PhotoException(String message, Throwable cause){
        super(message, cause);
    }
}
