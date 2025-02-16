package yuri_costa09.github.GerenciadorDeTarefas.repository;

import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> FindByUserId(Long userId);

}
