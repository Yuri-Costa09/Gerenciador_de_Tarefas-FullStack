package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import yuri_costa09.github.GerenciadorDeTarefas.security.SecurityConfig;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;
import yuri_costa09.github.GerenciadorDeTarefas.dtos.CreateUserDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Controller para operações com usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registra usuarios")
    @ApiResponse(responseCode = "201", description = "Usuario registrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario ja registrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity<User> register(@RequestBody CreateUserDto createUserDto) {
        User user = userService.registerUser(createUserDto);
        return ResponseEntity.ok(user);
    }
}
