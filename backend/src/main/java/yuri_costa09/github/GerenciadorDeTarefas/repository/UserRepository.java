package yuri_costa09.github.GerenciadorDeTarefas.repository;

import org.springframework.stereotype.Repository;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findIdByUsername(String username);
}
