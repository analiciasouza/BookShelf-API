package br.com.lab.project.controllers;


import br.com.lab.project.model.Books;
import br.com.lab.project.model.Users;
import br.com.lab.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Users user){
        var userCreated = userService.createUser(user);
        URI location = URI.create("/api/v1/users" + userCreated.getId());
        return ResponseEntity.created(location).build();
    }


    // list all
    @GetMapping
    public ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // list by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> getById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable UUID id, @RequestBody Users user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
