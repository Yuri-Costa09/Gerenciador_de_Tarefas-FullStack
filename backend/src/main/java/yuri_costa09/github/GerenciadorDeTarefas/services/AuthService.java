package yuri_costa09.github.GerenciadorDeTarefas.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.security.JwtService;

@Service
public class AuthService {

    private final JwtService jwtService;

    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String Authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }
}
