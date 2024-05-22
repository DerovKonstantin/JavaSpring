package ru.gb.homework_sem6.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.gb.homework_sem6.model.Task;
import ru.gb.homework_sem6.model.TaskStatus;
import ru.gb.homework_sem6.service.TaskService;

/*
    Базовое задание:
    Условие:
    Важно! В проекте используем обязательно Spring Data и Lombok!
    Разработайте небольшое веб-приложение на Spring Boot, которое будет представлять из себя сервис для учета личных заметок. Приложение должно поддерживать следующие функции:
    Все методы контроллера возвращают ResponseEntity(как на семинаре)
    1. Добавление заметки. (Подсказка @PostMapping )
    2. Просмотр всех заметок.(Подсказка @GetMapping )
    3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
    4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
    5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
    Структура заметки:
    - ID (автоинкрементное)(тип - Long)
    - Заголовок (не может быть пустым)(тип - String)
    - Содержимое (не может быть пустым)(тип - String)
    - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)

    Подсказка:
    Репозиторий насладует JpaRepository<Note, Long>. В репозитории добавляем метод Optional<Note> findById(Long id);
    Подсказка:
    В проект добавляем зависимости: spring data jpa, h2, lombok, spring web

    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    добавляем зависимотсть в pom файл подключаем библиотеку Swagger (Это инструмент для просмотра, создания и редактирования спецификаций OpenAPI в режиме реального времени)
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    http://localhost:8080/swagger-ui/index.html
    -----------------------------------------------------------


*/

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // 1. Добавление заметки. (Подсказка @PostMapping )
    @PostMapping
    public ResponseEntity<Task> createProduct(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    // 2. Просмотр всех заметок.(Подсказка @GetMapping )
    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    // Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
    @GetMapping("/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable(name = "status") TaskStatus status){ 
        return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
    }

    // 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
    @GetMapping("/{id}")
    public ResponseEntity<Task> getProduct(@PathVariable("id") Long id) {
        Task taskById;
        try {
            taskById = taskService.getTaskById(id).get();
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Task());
        }
        return new ResponseEntity<>(taskById, HttpStatus.OK);
    }

    // 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateProduct(@PathVariable(name = "id") Long id, @RequestBody Task task) {
        return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
    }

    // 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

}
