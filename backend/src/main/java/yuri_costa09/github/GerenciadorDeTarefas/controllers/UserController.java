package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;






}
