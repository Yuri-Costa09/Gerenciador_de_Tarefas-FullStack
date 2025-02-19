package yuri_costa09.github.GerenciadorDeTarefas.dtos;

public record CreateUserDto(
    String username,
    String email,
    String password
) {}