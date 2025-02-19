package yuri_costa09.github.GerenciadorDeTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Role.RoleType> {

}
