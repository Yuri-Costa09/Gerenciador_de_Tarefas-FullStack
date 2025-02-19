package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;
import yuri_costa09.github.GerenciadorDeTarefas.dtos.CreateUserDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody CreateUserDto createUserDto) {
        User user = userService.registerUser(createUserDto);
        return ResponseEntity.ok(user);
    }
}
