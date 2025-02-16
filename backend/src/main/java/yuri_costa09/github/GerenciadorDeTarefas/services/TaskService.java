package yuri_costa09.github.GerenciadorDeTarefas.services;

import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import yuri_costa09.github.GerenciadorDeTarefas.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuri_costa09.github.GerenciadorDeTarefas.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    // GET ALL BY USER ID:
    public List<Task> getTasksByUserId(long userId) {
        return taskRepository.findByUserId(userId);
    }

    // CREATE TASK
    public Task createTask(Task task) {

        // buscar o usuário pelo id
        User user = userService.getUserById(task.getUser().getId());

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
