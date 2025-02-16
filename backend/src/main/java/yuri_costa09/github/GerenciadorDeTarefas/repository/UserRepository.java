package yuri_costa09.github.GerenciadorDeTarefas.repository;

import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
