package ru.gb.homework_sem10.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


import ru.gb.homework_sem10.model.Task;
import ru.gb.homework_sem10.model.TaskStatus;
import ru.gb.homework_sem10.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceWithAnnotationUTest {

    @InjectMocks
    private TaskService service;

    @Mock
    private TaskRepository repository;

    @Test
    public void updateTaskCorrectFlow(){
        //Блок предусловия//........................
        Task task1 = new Task("Job", "Dont forget to go to work", TaskStatus.TO_DO);
        task1.setId(1L);
        task1.setCreationTime(LocalDateTime.now());

		Task task2 = new Task("Healthе", "Gym for", TaskStatus.TO_DO);
        task2.setId(1L);
        task2.setCreationTime(LocalDateTime.now());

        given(repository.findById(task1.getId())).willReturn(Optional.of(task1));
        //........................

        //Блок действия (вызова метода)//........................
        service.updateTask(task1.getId(),  task2);
        //........................

        //Блок проверки действия//........................
        assertEquals(repository.findById(1L).get() , task2);
        //........................
        
    }

    @Test
    public void updateTaskAccountNotFound(){

        //Блок предусловия//........................
        Task task1 = new Task("Job", "Dont forget to go to work", TaskStatus.TO_DO);
        task1.setId(1L);
        task1.setCreationTime(LocalDateTime.now());

        Task task2 = new Task("Healthе", "Gym for", TaskStatus.TO_DO);
        task2.setId(1L);
        task2.setCreationTime(LocalDateTime.now());

        given(repository.findById(task1.getId())).willReturn(Optional.empty());
        //........................

        //Блок действия (вызова метода)//........................
        assertThrows(NoSuchElementException.class, () -> {service.updateTask(task1.getId(), task2);});
        //........................

        //Блок проверки действия//........................
        assertThrows(NoSuchElementException.class, () -> {repository.findById(1L).get().equals(task2);});
        //........................
    }
    
}
