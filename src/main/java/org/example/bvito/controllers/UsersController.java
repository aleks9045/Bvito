package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.UserAdsSchema;
import org.example.bvito.schemas.UsersSchema;
import org.example.bvito.service.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
@Tag(name = "Users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> allUsers = usersService.getAllUsers();
        return ResponseEntity.status(200).body(allUsers);
    }

    @GetMapping("/{u_id}/ads")
    public ResponseEntity<UserAdsSchema> getUserAds(@PathVariable("u_id") int u_id) {
        UserAdsSchema userAdsSchema = usersService.getUserAds(u_id);
    return ResponseEntity.status(200).body(userAdsSchema);
    }

    @PostMapping("/")
    public ResponseEntity<Users> addUser(@Valid @RequestBody UsersSchema usersSchema) {
        Users addedUser = usersService.addUser(usersSchema);
        return ResponseEntity.created(
                        URI.create("/users/" + addedUser.getU_id()))
                .body(addedUser);
    }

    @GetMapping("/{u_id}")
    public ResponseEntity<Optional<Users>> getUser(@PathVariable("u_id") int u_id) {
        Optional<Users> user = usersService.getUserById(u_id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }

    @PutMapping("/{u_id}")
    public ResponseEntity<Users> putUser(@PathVariable("u_id") int u_id, @Valid @RequestBody UsersSchema usersSchema){
        Users updatedUser = usersService.updateUser(u_id, usersSchema);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/users/" + updatedUser.getU_id());

        return ResponseEntity.status(200).headers(headers).body(updatedUser);
    }

    @DeleteMapping("/{u_id}")
    public ResponseEntity deleteUser(@PathVariable("u_id") int u_id) {
        usersService.deleteUserById(u_id);
        return ResponseEntity.ok().build();
    }
}
