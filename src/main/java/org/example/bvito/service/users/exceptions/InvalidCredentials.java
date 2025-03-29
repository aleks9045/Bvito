package org.example.bvito.service.users.exceptions;
/**
 * Occurs when user's data not been verified
 *  @author Aleksey
 */
public class InvalidCredentials extends AuthException {
    public InvalidCredentials() {
        super("Invalid username or password");
    }
}
