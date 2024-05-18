package ru.gb.homework_sem5.model;


import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    public enum TaskStatus {
		TO_DO,
		IN_PROGRESS,
		DONE
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "task_discription", nullable = false)
	private String description;

    @Column(name = "task_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @Column(name = "creation_time", nullable = false)
	private LocalDateTime creationTime;

    @Column(name = "compltion_time", nullable = false)
	private LocalDateTime compltionTime;

}
