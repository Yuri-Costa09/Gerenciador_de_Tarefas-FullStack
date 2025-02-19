package yuri_costa09.github.GerenciadorDeTarefas.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import yuri_costa09.github.GerenciadorDeTarefas.dtos.CreateUserDto;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Role;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.repository.RoleRepository;
import yuri_costa09.github.GerenciadorDeTarefas.repository.UserRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }



    // GET:
    public User getUserById(long userId) {
        return userRepository.findById(userId).get();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // POST
    public User createUser(User user) {
        return userRepository.save(user);
     }

    // PATCH
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // DELETEbyID
    public void deleteUserById(long Id) {
        userRepository.deleteById(Id);
    }

   public User registerUser(CreateUserDto createUserDto) {
       if (userRepository.findByUsername(createUserDto.username()).isPresent()) {
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
