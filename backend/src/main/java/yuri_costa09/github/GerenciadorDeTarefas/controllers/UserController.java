package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
}
