package yuri_costa09.github.GerenciadorDeTarefas.repository;

import org.springframework.stereotype.Repository;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
