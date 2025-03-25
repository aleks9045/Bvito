package org.example.bvito.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.UsersSchema;
import org.example.bvito.service.UsersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/api/v1/users")
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

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody UsersSchema usersSchema) {
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
    public ResponseEntity<Users> putUser(@PathVariable("u_id") int u_id, @RequestBody UsersSchema usersSchema){
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
