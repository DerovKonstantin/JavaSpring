package ru.gb.homework_sem11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.gb.homework_sem11.model.Task;
import ru.gb.homework_sem11.model.TaskStatus;
import ru.gb.homework_sem11.repository.TaskRepository;

@SpringBootApplication
public class HomeworkSem11Application implements CommandLineRunner {
	@Autowired
	private final TaskRepository taskRepository;

	public HomeworkSem11Application(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeworkSem11Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task task1 = new Task("Job", "Dont forget to go to work", TaskStatus.TO_DO);
		Task task2 = new Task("Healthе", "Gym for", TaskStatus.TO_DO);

		taskRepository.save(task1);
		taskRepository.save(task2);
	}

}
