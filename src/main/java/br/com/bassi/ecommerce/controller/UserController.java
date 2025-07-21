package br.com.bassi.ecommerce.controller;

import br.com.bassi.ecommerce.dto.UserDto;
import br.com.bassi.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
