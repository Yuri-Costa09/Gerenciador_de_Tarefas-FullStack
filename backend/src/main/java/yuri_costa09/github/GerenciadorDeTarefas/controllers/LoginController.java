package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuri_costa09.github.GerenciadorDeTarefas.security.SecurityConfig;
import yuri_costa09.github.GerenciadorDeTarefas.services.AuthService;

@RestController
@RequestMapping("login")
@Tag(name = "Login", description = "Controller para operações de autentificação")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("authenticate")
    @Operation(summary = "Autentifica usuarios")
    @ApiResponse(responseCode = "200", description = "Usuario registrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuario ja registrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public String authenticate(Authentication authentication) {
        return authService.Authenticate(authentication);
    }
}
