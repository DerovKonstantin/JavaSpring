package ru.gb.microservice1_task.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
// @Table(name = "tasks")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "task_discription", nullable = false)
	private String description;

    // @Column(name = "task_status")
    // @Enumerated(EnumType.STRING)
    // private TaskStatus taskStatus;

    // @Column(name = "creation_time")
	// private LocalDateTime creationTime;

    // @PrePersist
    // public void prePresist() {
    //     creationTime = LocalDateTime.now();
    // }

    public Task(String name, String description) {
		this.name = name;
		this.description = description;
        // this.taskStatus = taskStatus;
	}

}