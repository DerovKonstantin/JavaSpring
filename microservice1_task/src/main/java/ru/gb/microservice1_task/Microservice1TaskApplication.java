package ru.gb.microservice1_task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.microservice1_task.model.Task;
import ru.gb.microservice1_task.repository.TaskRepository;



@SpringBootApplication
public class Microservice1TaskApplication implements CommandLineRunner {

	@Autowired
	private final TaskRepository taskRepository;

	public Microservice1TaskApplication(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Microservice1TaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task1 = new Task("Job", "Dont forget to go to work");
		Task task2 = new Task("Healthе", "Gym for");

		taskRepository.save(task1);
		taskRepository.save(task2);
	}

}
