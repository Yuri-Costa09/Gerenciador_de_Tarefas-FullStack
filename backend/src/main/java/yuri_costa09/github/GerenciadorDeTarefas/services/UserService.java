package yuri_costa09.github.GerenciadorDeTarefas.services;

import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

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


}
