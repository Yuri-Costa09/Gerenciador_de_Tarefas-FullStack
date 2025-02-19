package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuri_costa09.github.GerenciadorDeTarefas.services.AuthService;

@RestController
@RequestMapping("login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("authenticate")
    public String authenticate(Authentication authentication) {
        return authService.Authenticate(authentication);
    }
}
