package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    // GET:
    public User getUserById(long userId) {
        return userRepository.findById(userId).get();
    }

    public User getUserByUsername(String username) {
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
