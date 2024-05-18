package ru.gb.homework_sem5.service;

import lombok.AllArgsConstructor;
import ru.gb.homework_sem5.model.Task;
import ru.gb.homework_sem5.model.Task.TaskStatus;
import ru.gb.homework_sem5.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    
    /**
     * Получить все заачи.
     * @return список заачь.
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    public List<Task> getTasksByStatus(TaskStatus status){
        return repository.findAll().stream().filter(t -> t.getTaskStatus().equals(status)).toList();
    }

    public Task createTask(Task task){
        return repository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setTaskStatus(taskDetails.getTaskStatus());
            task.setCompltionTime(taskDetails.getCreationTime());
            task.setCompltionTime(taskDetails.getCompltionTime());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }

}
