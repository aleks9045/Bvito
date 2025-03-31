package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.users.out.SecureUserSchema;
import org.example.bvito.schemas.users.out.UserAdsSchema;
import org.example.bvito.schemas.users.in.UserSchema;
import org.example.bvito.schemas.users.UsersValidationGroups;
import org.example.bvito.service.users.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *  Rest controller for users operations (CRUD)
 *  <p>
 *  Process HTTP requests to work with {@link Users} model
 *  Every method returns data in JSON format
 *
 *  @author Aleksey
 *
 * @see UsersService Service layer interface for business logic
 * @see Users User model
 */
@RestController
@RequestMapping(path = "/api/v1/users")
@Tag(name = "Users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{u_id}/ads")
    public ResponseEntity<UserAdsSchema> getUserAds(@PathVariable("u_id") int u_id) {
        UserAdsSchema userAdsSchema = usersService.getUserAds(u_id);
        return ResponseEntity.status(200).body(userAdsSchema);
    }

    @GetMapping("/{u_id}")
    public ResponseEntity<SecureUserSchema> getUser(@PathVariable("u_id") int u_id) {
        SecureUserSchema secureUserSchema = usersService.getUserById(u_id);

        return ResponseEntity.status(200).body(secureUserSchema);
    }

    @PatchMapping("/{u_id}")
    public ResponseEntity<SecureUserSchema> putUser(@PathVariable("u_id") int u_id,
                                         @Validated(UsersValidationGroups.OnUpdate.class)
                                         @RequestBody UserSchema userSchema) {
        SecureUserSchema updatedUser = usersService.updateUser(u_id, userSchema);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/users/" + updatedUser.getuId());

        return ResponseEntity.status(200).headers(headers).body(updatedUser);
    }

    @DeleteMapping("/{u_id}")
    public ResponseEntity<?> deleteUser(@PathVariable("u_id") int u_id) {
        usersService.deleteUserById(u_id);
        return ResponseEntity.status(200).build();
    }
}
