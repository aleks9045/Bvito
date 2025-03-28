package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.UsersValidationGroups;
import org.example.bvito.schemas.users.in.UserAuthenticateSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.service.users.UsersService;
import org.example.bvito.service.users.exceptions.InvalidCredentials;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/auth")
@Tag(name = "Auth")
public class AuthController {
    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> addUser(@Validated(UsersValidationGroups.OnCreate.class)
                                         @RequestBody UserSchema userSchema) {
        usersService.addUser(userSchema);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated(UsersValidationGroups.OnUpdate.class)
                                                             @RequestBody UserAuthenticateSchema userAuthenticateSchema){
        try {
            SecureUserSchema secureUserSchema = usersService.getUserByCredentials(userAuthenticateSchema);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/users/" + secureUserSchema.getU_id());

            return ResponseEntity.status(200).headers(headers).body(secureUserSchema);
        } catch (InvalidCredentials e){
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }
}
