package yuri_costa09.github.GerenciadorDeTarefas.services;

import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    // GET ALL BY USER ID:
    public List<Task> getTasksByUserId(long userId) {

        return taskRepository.findByUserId(userId);
    }

    // CREATE TASK
    public Task createTask(Task task, long id) {

        // buscar o usuário pelo id
        User user = userService.getUserById(id);

        // setar o usuário no task
        task.setUser(user);

        return taskRepository.save(task);
    }

    // PATCH
    public Task updateTask(Task task) {

        return taskRepository.save(task);
    }

    // DELETEbyID
    public void deleteTaskById(long Id) {

        taskRepository.deleteById(Id);
    }
}
