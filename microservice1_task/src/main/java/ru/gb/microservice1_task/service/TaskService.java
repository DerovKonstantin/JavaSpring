package ru.gb.microservice1_task.service;


import org.springframework.stereotype.Service;

import ru.gb.microservice1_task.model.Task;
import ru.gb.microservice1_task.repository.TaskRepository;
import ru.gb.microservice1_task.util.CustomResponse;
import ru.gb.microservice1_task.util.CustomStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
		this.repository = repository;
	}
    
    public CustomResponse<Task> getAll(){
        List<Task> tasks = repository.findAll();
        return new CustomResponse<>(tasks, CustomStatus.SUCCESS);
    }

    public CustomResponse<Task> getById(Long id){
        Task task = repository.findById(id).get();
        return new CustomResponse<>(Stream.of(task).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }

    // public CustomResponse<Task> getByStatus(TaskStatus status){
    //     List<Task> tasks = repository.findAll().stream().filter(t -> t.getTaskStatus().equals(status)).toList();
    //     return new CustomResponse<>(tasks, CustomStatus.SUCCESS);
    // }

    public CustomResponse<Task> addTask(Task task){
        Task newTask = repository.save(task);
        return new CustomResponse<>(Stream.of(newTask).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }


    // public CustomResponse<Task> updateTask(Long id, Task taskDetails){
    //     Optional<Task> optionalTask = repository.findById(id);
    //     if (optionalTask.isPresent()) {
    //         Task task = optionalTask.get();
    //         task.setName(taskDetails.getName());
    //         task.setDescription(taskDetails.getDescription());
    //         task.setTaskStatus(taskDetails.getTaskStatus());
    //         task.setCompltionTime(taskDetails.getCreationTime());
    //         task.setCompltionTime(taskDetails.getCompltionTime());
    //         Task newTask = repository.save(task);
    //         return new CustomResponse<>(Stream.of(newTask).collect(Collectors.toList()), CustomStatus.SUCCESS);
    //     } else {
    //         throw new IllegalArgumentException("Task not found with id: " + id);
    //     }
    // }

    // public void deleteTask(Long id){
    //     repository.deleteById(id);
    // }

}
