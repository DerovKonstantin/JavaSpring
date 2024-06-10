package ru.gb.homework_sem10.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ru.gb.homework_sem10.model.Task;
import ru.gb.homework_sem10.model.TaskStatus;
import ru.gb.homework_sem10.service.TaskService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class TaskServiceWithAnnotationIntegration {

	@Autowired
    private TaskService service;

    @MockBean
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

        when(repository.findById(task1.getId())).thenReturn(Optional.of(task1));
        //........................

        //Блок действия (вызова метода)//........................
        service.updateTask(task1.getId(), task2);
        //........................

        //Блок проверки действия//........................
        assertEquals(repository.findById(1L).get() , task2);
        //........................

    }
}
