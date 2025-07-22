package br.com.bassi.ecommerce.controller;

import br.com.bassi.ecommerce.domain.User;
import br.com.bassi.ecommerce.dto.UserDto;
import br.com.bassi.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto dto){

        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getId())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable("userId")UUID userId){

        var user = userService.findById(userId);

        return user.isPresent()?
                ResponseEntity.ok(user.get()):
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletedById(@PathVariable("userId")UUID userId){

        var deleted = userService.deletedById(userId);

        return deleted ?
                ResponseEntity.noContent().build():
                ResponseEntity.notFound().build();
    }

}
