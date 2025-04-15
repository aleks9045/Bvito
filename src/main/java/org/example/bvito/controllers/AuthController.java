package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.User;
import org.example.bvito.schemas.user.UsersValidationGroups;
import org.example.bvito.schemas.user.in.UserAuthenticateSchema;
import org.example.bvito.schemas.user.in.UserSchema;
import org.example.bvito.schemas.user.out.SecureUserSchema;
import org.example.bvito.service.users.UsersService;
import org.example.bvito.service.users.exceptions.InvalidCredentials;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *  Rest controller for authentication and authorization logic
 *  <p>
 *  Process HTTP requests to work with {@link User} model
 *  Every method returns data in JSON format
 *
 *  @author Aleksey
 *
 * @see UsersService Service layer interface for business logic
 * @see User User model
 */
@RestController
@RequestMapping(path = "api/v1/auth")
@Tag(name = "Auth")
public class AuthController {
    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@Validated(UsersValidationGroups.OnCreate.class)
                                         @RequestBody UserSchema userSchema) {
        usersService.addUser(userSchema);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated(UsersValidationGroups.OnUpdate.class)
                                              @RequestBody UserAuthenticateSchema userAuthenticateSchema) {
        try {
            SecureUserSchema secureUserSchema = usersService.getUserByCredentials(userAuthenticateSchema);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/users/" + secureUserSchema.getUserId());

            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(secureUserSchema);
        } catch (InvalidCredentials e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }
}
