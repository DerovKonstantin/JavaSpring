package ru.gb.microservice1_task.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.gb.microservice1_task.model.Task;


@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
}
