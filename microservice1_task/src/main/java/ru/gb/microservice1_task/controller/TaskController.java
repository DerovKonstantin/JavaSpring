package ru.gb.microservice1_task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.gb.microservice1_task.model.Task;
import ru.gb.microservice1_task.service.TaskService;
import ru.gb.microservice1_task.util.CustomResponse;



@RestController
@RequestMapping("/tasks")
// @AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

    // Просмотр всех задач.
    @GetMapping()
    public CustomResponse<Task> getAllTask(){
        return taskService.getAll();
    }

    // Добавление задачи.
    @PostMapping("/task")
    public CustomResponse<Task> addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    // Просмотр задач по id
    @GetMapping("/{id}")
    public CustomResponse<Task> getTaskById(@PathVariable(name = "id") Long id){
        return taskService.getById(id);
    }

    // // Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
    // @GetMapping("/status/{status}")
    // public CustomResponse<Task> getTasksByStatus(@PathVariable(name = "status") TaskStatus status){ 
    //     return taskService.getByStatus(status);
    // }

    // // Изменение статуса задачи.
    // @PutMapping("/{id}")
    // public CustomResponse<Task> updateTask(@PathVariable(name = "id") Long id, @RequestBody Task task){
    //     return taskService.updateTask(id, task);
    // }

    // // Удаление задачи.
    // @DeleteMapping("/{id}")
    // public void deleteTask(@PathVariable(name = "id") Long id){
    //     taskService.deleteTask(id);
    // }

}