package yuri_costa09.github.GerenciadorDeTarefas.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found"));
    }
}