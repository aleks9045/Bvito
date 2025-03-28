package org.example.bvito.service.users.exceptions;

public class InvalidCredentials extends Exception {
    public InvalidCredentials() {
        super("Invalid username or password");
    }
}
