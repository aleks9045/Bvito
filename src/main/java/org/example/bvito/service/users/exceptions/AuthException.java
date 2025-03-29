package org.example.bvito.service.users.exceptions;

/**
 * Base Authorization error
 * @author Aleksey
 */
public class AuthException extends RuntimeException {
    public AuthException(String error) {
        super(error);
    }
}
