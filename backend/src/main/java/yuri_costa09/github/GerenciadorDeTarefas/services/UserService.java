package yuri_costa09.github.GerenciadorDeTarefas.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import yuri_costa09.github.GerenciadorDeTarefas.dtos.CreateUserDto;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Role;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // GET: User ID
    public User getUserById(long userId) {
        return userRepository.findById(userId).get();
    }

    // GET: User ID by Username
    public Long getUserIdByUsername(String username) {
        User user = userRepository.findIdByUsername(username);
        return user.getId();
    }

    // GET: User By Username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // PATCH: Update User
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // DELETE: User By Id
    public void deleteUserById(long Id) {
        userRepository.deleteById(Id);
    }

    // POST: Register User
    public User registerUser(CreateUserDto createUserDto) {
        if (userRepository.findByUsername(createUserDto.username()) != null) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(createUserDto.username());
        user.setEmail(createUserDto.email());
         user.setPassword(passwordEncoder.encode(createUserDto.password()));

        Role userRole = new Role();
        userRole.setName(Role.RoleType.ROLE_USER);
        user.setRoles(Set.of(userRole));

        return userRepository.save(user);
    }
}
