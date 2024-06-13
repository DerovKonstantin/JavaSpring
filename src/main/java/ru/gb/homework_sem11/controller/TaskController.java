package ru.gb.homework_sem11.controller;

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

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import ru.gb.homework_sem11.model.Task;
import ru.gb.homework_sem11.model.TaskStatus;
import ru.gb.homework_sem11.service.TaskService;

/*
   
*/

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final Counter addNoteCounter = Metrics.counter("add_note_counte");

    private final TaskService taskService;

    // 1. Добавление заметки
    @PostMapping
    public ResponseEntity<Task> createProduct(@RequestBody Task task) {

        addNoteCounter.increment();
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    // 2. Просмотр всех заметок
    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    // Просмотр задач по статусу
    @GetMapping("/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable(name = "status") TaskStatus status){ 
        return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
    }

    // 3. Получение заметки по id
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

    // 4. Редактирование заметки
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateProduct(@PathVariable(name = "id") Long id, @RequestBody Task task) {
        return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
    }

    // 5. Удаление заметки
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

}
