package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import yuri_costa09.github.GerenciadorDeTarefas.services.TaskService;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    // GET todas as tasks pelo user ID
    @GetMapping("/get")
    public List<Task> getAllTasksByUserId() {

        // seleciona o usuario autenticado atual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // seleciona o username do user da sessao atual
        String username = authentication.getName();
        // pega a ID do user pelo username
        long userId = userService.getUserIdByUsername(username);

        return taskService.getTasksByUserId(userId);

    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        long userId = userService.getUserIdByUsername(username);

        return taskService.createTask(task, userId);
    }

    @PatchMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable long id) {
        taskService.deleteTaskById(id);
    }
}
