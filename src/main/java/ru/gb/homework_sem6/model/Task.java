package ru.gb.homework_sem6.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

// Структура заметки:
//     - ID (автоинкрементное)(тип - Long)
//     - Заголовок (не может быть пустым)(тип - String)
//     - Содержимое (не может быть пустым)(тип - String)
//     - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "task_discription", nullable = false)
	private String description;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "creation_time")
	private LocalDateTime creationTime;

    // public Task() {
    //     this.taskStatus = TaskStatus.TO_DO;
    //     this.creationTime = LocalDateTime.now();
    // }

}
