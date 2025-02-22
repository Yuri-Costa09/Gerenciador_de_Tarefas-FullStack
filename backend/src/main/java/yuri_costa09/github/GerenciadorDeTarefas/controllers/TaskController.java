package yuri_costa09.github.GerenciadorDeTarefas.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import yuri_costa09.github.GerenciadorDeTarefas.entities.Task;
import yuri_costa09.github.GerenciadorDeTarefas.security.SecurityConfig;
import yuri_costa09.github.GerenciadorDeTarefas.services.TaskService;
import yuri_costa09.github.GerenciadorDeTarefas.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task", description = "Controller para operações com Tasks")
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    // GET todas as tasks pelo user ID
    @GetMapping("/get")
    @Operation(summary = "Procura todos os usuarios pelo ID")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuario nao encontrado")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public List<Task> getAllTasksByUserId() {

        // seleciona o usuario autenticado atual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // seleciona o username do user da sessao atual
        String username = authentication.getName();
        // pega a ID do user pelo username
        long userId = userService.getUserIdByUsername(username);
        var tasks = taskService.getTasksByUserId(userId);
        return ResponseEntity.ok(tasks).getBody();

    }

    @PostMapping("/create")
    @Operation(summary = "Cria uma Task")
    @ApiResponse(responseCode = "201", description = "Task criada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public Task createTask(@RequestBody Task task) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        long userId = userService.getUserIdByUsername(username);
        var createdTask = taskService.createTask(task, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask).getBody();
    }

    @PatchMapping("/update")
    @Operation(summary = "Edita uma Task")
    @ApiResponse(responseCode = "201", description = "Task Editada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public Task updateTask(@RequestBody Task task) {
        var updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask).getBody();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta uma Task")
    @ApiResponse(responseCode = "200", description = "Task Deletada")
    @ApiResponse(responseCode = "404", description = "Task nao encontrada")
    @ApiResponse(responseCode = "500", description = "Erro no servidor")
    public ResponseEntity.BodyBuilder deleteTaskById(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok();
    }
}
