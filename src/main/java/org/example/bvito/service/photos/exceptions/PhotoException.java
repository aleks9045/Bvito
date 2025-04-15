package org.example.bvito.service.photos.exceptions;

/**
 * Base photo exception
 *
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
