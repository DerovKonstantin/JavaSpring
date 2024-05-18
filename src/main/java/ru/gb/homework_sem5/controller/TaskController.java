package ru.gb.homework_sem5.controller;

import lombok.AllArgsConstructor;
import ru.gb.homework_sem5.model.Task;
import ru.gb.homework_sem5.model.Task.TaskStatus;
import ru.gb.homework_sem5.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Просмотр всех задач.
    @GetMapping()
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    // Добавление задачи.
    // @PostMapping 
    // public Task addTask(@RequestBody Task task)
    @PostMapping("/task")
    public Task addTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    // Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
    // @GetMapping("/status/{status}") 
    // public List getTasksByStatus(@PathVariable TaskStatus status)
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable(name = "status") TaskStatus status){ 
        return taskService.getTasksByStatus(status);
    }

    // Изменение статуса задачи.
    // Подсказка метод в контроллере: 
    // @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable(name = "id") Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    // Удаление задачи.
    // Подсказка метод в контроллере:
    // @DeleteMapping("/{id}") public void deleteTask(@PathVariable Long id)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id){
        taskService.deleteTask(id);
    }

}
