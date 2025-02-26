package yuri_costa09.github.GerenciadorDeTarefas.repository;

import org.springframework.stereotype.Repository;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserId(Long userId);

}
