package org.example.bvito.service.users.exceptions;

/**
 * Base Authorization error
 * @author Aleksey
 */
public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
